package org.nhnnext.nextstep.session;

import org.nhnnext.nextstep.core.repository.AuditingRepository;
import org.springframework.data.repository.CrudRepository;

public interface MasterSessionRepository extends AuditingRepository<MasterSession, Long>{

}
