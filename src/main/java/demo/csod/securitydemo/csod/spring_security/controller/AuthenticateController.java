package demo.csod.securitydemo.csod.spring_security.controller;

import demo.csod.securitydemo.csod.spring_security.exception.ResourceNotFound;
import demo.csod.securitydemo.csod.spring_security.models.Users;
import demo.csod.securitydemo.csod.spring_security.repository.UserRepository;
import demo.csod.securitydemo.csod.spring_security.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/api")
@Slf4j
public class AuthenticateController {

    @Autowired
    RegisterService registerService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/index")
    public String homepage() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    public ResponseEntity<Users> register(Users user) {
        String passwordSalt = encryptPassword(user.getPassword());
        user.setPassword(passwordSalt);
        log.info("Registration successful! User Created with username: {}", user.getUserName());
        return new ResponseEntity<>(registerService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestParam String emailId, @RequestParam String password
                       ) {
        Optional<Users> user = Optional.of(userRepository.findByEmailId(emailId).orElseThrow(() ->
                new ResourceNotFound("User not found", "User id is not in our records")));
        if (user.isPresent()) {
            if (matchPassword(user, password)) {
                log.info("User with username - {} logged in", user.get().getUserName());
                return "welcome";
            }
        }
        return "error";
    }

    private String encryptPassword(String password) {
        String hashedPwd = passwordEncoder.encode(password);
        return hashedPwd;
    }

    private boolean matchPassword(Optional<Users> user, String loginPassword) {
        String savedPassword = user.get().getPassword();
        if (passwordEncoder.matches(loginPassword, savedPassword))
            return true;
        return false;
    }
}
