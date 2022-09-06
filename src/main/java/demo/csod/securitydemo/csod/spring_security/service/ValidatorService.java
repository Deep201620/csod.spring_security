package demo.csod.securitydemo.csod.spring_security.service;

import demo.csod.securitydemo.csod.spring_security.exception.ResourceNotFound;
import demo.csod.securitydemo.csod.spring_security.exception.UserAlreadyExists;
import demo.csod.securitydemo.csod.spring_security.models.Users;
import demo.csod.securitydemo.csod.spring_security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static demo.csod.securitydemo.csod.spring_security.utils.Iconstant.USER_EXIST;

@Slf4j
@Service
public class ValidatorService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean userExist(String emailId) {
        Optional<Users> user = userRepository.findByEmailId(emailId);
        if (user.isEmpty())
            return false;
        throw new UserAlreadyExists(101, USER_EXIST);
    }

    public boolean matchPassword(Optional<Users> user, String loginPassword) {
        String savedPassword = user.get().getPassword();
        return passwordEncoder.matches(loginPassword, savedPassword);
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean authenticateUser(String emailId, String password) {
        Optional<Users> user = Optional.of(userRepository.findByEmailId(emailId).
                orElseThrow(() -> new ResourceNotFound("User with {}", emailId, "Not found")));
        return matchPassword(user, password);
    }
}
