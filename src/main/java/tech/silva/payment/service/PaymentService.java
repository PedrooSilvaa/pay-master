package tech.silva.payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.silva.payment.entity.Payment;
import tech.silva.payment.entity.User;
import tech.silva.payment.exception.ObjectNotFoundException;
import tech.silva.payment.repository.IPaymentRepository;
import tech.silva.payment.repository.IUserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final IPaymentRepository paymentRepository;
    private final IUserRepository userRepository;

    @Transactional
    public Payment addUserToPayment(Long id, Long minutesLimit){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expire = now.plusMinutes(minutesLimit);

        User user = userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("User not found")
        );

        Payment payment = new Payment();
        payment.setUser(user);
        payment.setExpirationDate(expire);
        return paymentRepository.save(payment);
    }

    @Transactional
    @Scheduled(fixedDelay = 10000)
    public void addPayment(){
        List<Payment> payments = paymentRepository.findAll();
        payments.stream()
                .forEach(payment -> {
                    if (!payment.getExpirationDate().isAfter(LocalDateTime.now())){
                        paymentRepository.deleteById(payment.getId());
                    }else {
                        User user = userRepository.findById(payment.getUser().getId()).orElseThrow(
                                () -> new ObjectNotFoundException("User not found")
                        );

                        user.setValue(user.getValue() + 100.0f);
                        userRepository.save(user);
                    }
                });
        log.info(String.valueOf(LocalDateTime.now()));
    }

}
