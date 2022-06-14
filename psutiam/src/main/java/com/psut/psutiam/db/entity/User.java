package com.psut.psutiam.db.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "my_user")
@Table(
        name = "my_user",
        indexes = {
                @Index(name = "my_user_email", columnList = "email"),
        })
@PrimaryKeyJoinColumn(name = "id")
public class User extends Identity {

    @Column(name = "email", unique = true)
    private String email;
    private String firstName;
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User identity = (User) o;
        return getId() == identity.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
