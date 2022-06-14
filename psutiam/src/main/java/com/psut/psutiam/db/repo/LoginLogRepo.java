package com.psut.psutiam.db.repo;

import com.psut.psutiam.db.entity.IdentityRel;
import com.psut.psutiam.db.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepo extends JpaRepository<LoginLog, Long> {

}
