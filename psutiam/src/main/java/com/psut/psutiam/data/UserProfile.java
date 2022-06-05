package com.psut.psutiam.data;


import com.psut.psutiam.db.entity.Role;

import java.util.Objects;

public class UserProfile {
    private String externalId;
//    @NotEmpty
//    @Email
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private Role role;

    public UserProfile(String externalId, String email, String username, String firstName, String lastName, Role role) {
        this.externalId = externalId;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        UserProfile that = (UserProfile) o;
        return externalId.equals(that.externalId) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId, email);
    }
}
