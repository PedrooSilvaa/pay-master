package tech.silva.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.silva.payment.repository.IPaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final IPaymentRepository paymentRepository;

}
