package pl.szbd.virtual.university.domain.commons.model.entities;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "APP_USERS")
public class User {
    private String id;
    private Person person;
    private String username;
    private String password;
    private Date lastLogin;


    @Id
    @PESEL
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "PESEL")
    @MapsId
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "LOGIN", unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "LAST_LOGIN_DATE")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date date) {
        this.lastLogin = date;
    }



    @Override
    public String toString() {
        return "{ " +
                ", username: '" + username + '\'' +
                ", password: '" + password + '\'' +
                ", lastLogin: " + lastLogin +
                ", personId: '" +  this.person.getPesel()+ '\'' +
                " }";
    }
}
