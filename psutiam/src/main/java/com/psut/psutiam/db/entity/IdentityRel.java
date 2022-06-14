package com.psut.psutiam.db.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "my_identityrel")
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"identity1", "identity2", "RelType"})
})
public class IdentityRel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "identity1", nullable = false)
    private Identity identity1;

    @ManyToOne
    @JoinColumn(name = "identity2", nullable = false)
    private Identity identity2;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RelType relType;

    private Date createdDate = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityRel that = (IdentityRel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public RelType getRelType() {
        return relType;
    }

    public void setRelType(RelType relType) {
        this.relType = relType;
    }


    public Identity getIdentity2() {
        return identity2;
    }

    public void setIdentity2(Identity identity2) {
        this.identity2 = identity2;
    }

    public Identity getIdentity1() {
        return identity1;
    }

    public void setIdentity1(Identity identity1) {
        this.identity1 = identity1;
    }
}
