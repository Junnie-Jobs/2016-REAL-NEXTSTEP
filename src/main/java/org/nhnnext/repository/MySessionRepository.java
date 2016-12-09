package org.nhnnext.repository;

import org.nhnnext.domain.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MySessionRepository extends CrudRepository<Session, Long> {
}

