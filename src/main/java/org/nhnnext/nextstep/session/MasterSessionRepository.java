package org.nhnnext.nextstep.session;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = MasterSessionExcerpt.class)
public interface MasterSessionRepository extends CrudRepository<MasterSession, Long>{

}
