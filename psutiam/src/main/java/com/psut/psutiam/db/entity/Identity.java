package com.psut.psutiam.db.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "my_identity")
@Table(
        name="my_identity",
        indexes = {
                @Index(name = "my_identity_id", columnList = "id"),
                @Index(name = "my_identity_uuid", columnList = "uuid") })
@Inheritance(strategy = InheritanceType.JOINED)
public class Identity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String uuid = UUID.randomUUID().toString();

    private Date createdDate = new Date();

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identity identity = (Identity) o;
        return id == identity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}