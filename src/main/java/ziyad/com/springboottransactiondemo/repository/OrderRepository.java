package ziyad.com.springboottransactiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ziyad.com.springboottransactiondemo.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {


}
