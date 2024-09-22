package tech.silva.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.silva.payment.repository.IUserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

}
