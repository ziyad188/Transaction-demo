package ziyad.com.springboottransactiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ziyad.com.springboottransactiondemo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
