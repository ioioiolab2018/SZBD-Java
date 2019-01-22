package pl.szbd.virtualuniversity.domain.commons.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "APP_USERS")
public class User {
    private String personId;
    private String username;
    private String password;
    private Date lastLogin;

    @Id
    @Column(name = "PERSON_ID", unique = true)
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "USERNAME", unique = true)
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

    public User(String personId, String username, String password, Date lastLogin) {
        this.personId = personId;
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", person_id='" + personId + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
