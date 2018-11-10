package pl.szbd.virtual.university.domain.commons.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "APP_USERS")
public class User {
    private Long id;
    private String username;
    private String password;
    private Date lastLogin;
    private String personId;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Column(name = "PERSON_ID")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "{ " +
                "id: " + id +
                ", username: '" + username + '\'' +
                ", password: '" + password + '\'' +
                ", lastLogin: " + lastLogin +
                ", personId: '" + personId + '\'' +
                " }";
    }
}
