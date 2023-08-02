package ziyad.com.springboottransactiondemo.service;

import ziyad.com.springboottransactiondemo.dto.OrderReequest;
import ziyad.com.springboottransactiondemo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderReequest orderReequest);

}
