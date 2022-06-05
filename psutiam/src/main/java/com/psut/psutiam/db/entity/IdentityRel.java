package com.psut.psutiam.db.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

//@Entity("IdentityRel")
//@Table(uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"user", "login", "RelType"})
//})
public class IdentityRel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user", nullable = false)
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "login", nullable = false)
//    private Login login;
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private RelType relType;
//
//    private Date createdDate = new Date();
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        IdentityRel that = (IdentityRel) o;
//        return id == that.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    public RelType getRelType() {
//        return relType;
//    }
//
//    public void setRelType(RelType relType) {
//        this.relType = relType;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Login getLogin() {
//        return login;
//    }
//
//    public void setLogin(Login login) {
//        this.login = login;
//    }
}
