package tech.silva.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.silva.payment.entity.User;
import tech.silva.payment.repository.IUserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    @Transactional
    public User createUser(User user){
        try {
            return userRepository.save(user);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException(String.format("User with cpf: %s already registered", user.getCpf()));
        }
    }

    @Transactional(readOnly = true)
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

}
