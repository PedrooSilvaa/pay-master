package tech.silva.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.payment.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
