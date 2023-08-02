package ziyad.com.springboottransactiondemo.dto;

import lombok.Getter;
import lombok.Setter;
import ziyad.com.springboottransactiondemo.entity.Order;
import ziyad.com.springboottransactiondemo.entity.Payment;
@Getter
@Setter
public class OrderReequest {
    private Order order;
    private Payment payment;
}
