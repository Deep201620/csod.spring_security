package demo.csod.securitydemo.csod.spring_security.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @Column(unique = true)
    private String emailId;

    @Setter(AccessLevel.PROTECTED)
    private LocalDate bDate;

    private String password;

    public void setbDate(String bDate) {
        this.bDate = LocalDate.parse(bDate);
    }

}
