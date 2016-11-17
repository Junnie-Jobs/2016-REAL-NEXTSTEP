package org.nhnnext.repository;

import org.nhnnext.domain.Session;
import org.nhnnext.domain.SessionExcerpt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = SessionExcerpt.class)
public interface SessionRepository extends CrudRepository<Session, Long> {
}
