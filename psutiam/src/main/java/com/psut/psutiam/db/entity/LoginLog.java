package com.psut.psutiam.db.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "my_loginLog")
@Table(
        name = "my_loginLog",
        indexes = {
                @Index(name = "my_login_loginTime", columnList = "loginTime"),
        })
public class LoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String email;

    private Date loginTime = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
