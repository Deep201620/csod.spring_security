package demo.csod.securitydemo.csod.spring_security;

import demo.csod.securitydemo.csod.spring_security.models.Users;
import demo.csod.securitydemo.csod.spring_security.service.RegisterService;
import demo.csod.securitydemo.csod.spring_security.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequestMapping("api2/")
public class AuthenticateController {

    @Autowired
    RegisterService registerService;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value="/saveUser", consumes = ("*/*"),produces = {"application/json"})
    public ResponseEntity<Users> register(Users user){
        return new ResponseEntity<>(registerService.saveUser(user),HttpStatus.CREATED);
    }


    @PostMapping(value = "/login", consumes = ("*/*"))
    public String login(@RequestParam String emailId, @RequestParam String password) {
        System.out.println("Inside Login API");
        Optional<Users> user = userRepository.findByEmailId(emailId);
        if(user.isPresent()){
            String saved_password = user.get().getPassword();
            if(saved_password.equals(password)) {

                return "welcome";
            }
        }
        return "error";
    }
}
