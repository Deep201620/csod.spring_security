package demo.csod.securitydemo.csod.spring_security.service;

import demo.csod.securitydemo.csod.spring_security.models.Users;
import demo.csod.securitydemo.csod.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByEmailId(emailId);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + emailId));
        UserDetails userDetails = User.withUsername(user.get().getUserName())
                .password(user.get().getPassword()).build();
        return userDetails;
    }
}
