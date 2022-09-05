package demo.csod.securitydemo.csod.spring_security;

import demo.csod.securitydemo.csod.spring_security.models.Users;
import demo.csod.securitydemo.csod.spring_security.service.RegisterService;
import demo.csod.securitydemo.csod.spring_security.repository.UserRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("api/")
public class AuthenticateController {

    @Autowired
    RegisterService registerService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    Logger logger = LogManager.getLogger(AuthenticateController.class);

    @PostMapping("/register")
    public ResponseEntity<Users> register(Users user) {
        String passwordSalt = encryptPassword(user.getPassword());
        user.setPassword(passwordSalt);
        logger.info("Registration successful! User Created with username: {}"+user.getUserName());
        return new ResponseEntity<>(registerService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestParam String emailId, @RequestParam String password, Model model,HttpServletRequest httpServletRequest) {
        Optional<Users> user = userRepository.findByEmailId(emailId);
        if (user.isPresent()) {
            if (matchPassword(user,password)) {
                logger.info("User with username - {} logged in",user.get().getUserName());
                return "welcome";
            }
        }
        return "error";
    }
    private String encryptPassword(String password) {
        String hashedPwd = passwordEncoder.encode(password);
        return hashedPwd;
    }

    private boolean matchPassword(Optional<Users> user, String loginPassword){
        String savedPassword = user.get().getPassword();
        if(passwordEncoder.matches(loginPassword,savedPassword))
            return true;
        return false;
    }
}
