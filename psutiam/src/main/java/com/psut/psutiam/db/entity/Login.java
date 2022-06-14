package com.psut.psutiam.db.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "my_login")
@Table(
        name = "my_login",
        indexes = {
                @Index(name = "my_login_email", columnList = "username"),
        })
@PrimaryKeyJoinColumn(name = "id")
public class Login extends Identity {

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean firstTime = true;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login identity = (Login) o;
        return getId() == identity.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }
}
