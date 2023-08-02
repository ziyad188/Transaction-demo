package ziyad.com.springboottransactiondemo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ziyad.com.springboottransactiondemo.Exception.PaymentException;
import ziyad.com.springboottransactiondemo.dto.OrderReequest;
import ziyad.com.springboottransactiondemo.dto.OrderResponse;
import ziyad.com.springboottransactiondemo.entity.Order;
import ziyad.com.springboottransactiondemo.entity.Payment;
import ziyad.com.springboottransactiondemo.repository.OrderRepository;
import ziyad.com.springboottransactiondemo.repository.PaymentRepository;
import ziyad.com.springboottransactiondemo.service.OrderService;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    //this method execute in single transaction
    //now this will roll back when this exception came
    @Transactional(rollbackFor = PaymentException.class)

    public OrderResponse placeOrder(OrderReequest orderReequest) {
        Order order = orderReequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderReequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");

        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
