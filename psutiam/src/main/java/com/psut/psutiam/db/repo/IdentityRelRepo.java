package com.psut.psutiam.db.repo;

//import com.psut.psutiam.db.entity.Identity;

import com.psut.psutiam.db.entity.Identity;
import com.psut.psutiam.db.entity.IdentityRel;
import com.psut.psutiam.db.entity.RelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

//@Service
public interface IdentityRelRepo extends JpaRepository<IdentityRel, Long> {
    IdentityRel findIdentityRelByIdentity1AndRelType(Identity identity1, RelType RelType);
}
