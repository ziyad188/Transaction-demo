package ziyad.com.springboottransactiondemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ziyad.com.springboottransactiondemo.dto.OrderReequest;
import ziyad.com.springboottransactiondemo.dto.OrderResponse;
import ziyad.com.springboottransactiondemo.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderReequest orderReequest){
        return ResponseEntity.ok(orderService.placeOrder(orderReequest));

    }
}
