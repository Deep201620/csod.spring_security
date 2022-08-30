package demo.csod.securitydemo.csod.spring_security.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Login {
    @Id
    private String emailId;
    private String password;
    private int logincounter;

}
