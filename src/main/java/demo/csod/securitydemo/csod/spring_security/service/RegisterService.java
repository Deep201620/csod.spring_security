package demo.csod.securitydemo.csod.spring_security.service;

import demo.csod.securitydemo.csod.spring_security.models.Users;
import demo.csod.securitydemo.csod.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService{

    @Autowired
    UserRepository userRepository;

    public Users saveUser(Users user){
        Users savedUser = userRepository.save(user);
        return savedUser;
    }


}
