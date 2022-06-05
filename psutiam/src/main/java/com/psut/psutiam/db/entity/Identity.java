//package com.psut.psutiam.db.entity;
//
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Objects;
//
//@Entity(name = "identity")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Identity {
}

//
//
//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Identity identity = (Identity) o;
//        return id == identity.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}