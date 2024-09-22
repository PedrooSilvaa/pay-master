package tech.silva.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.payment.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {
}
