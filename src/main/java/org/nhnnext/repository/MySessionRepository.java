package org.nhnnext.repository;

import org.nhnnext.domain.Session;
import org.springframework.data.repository.CrudRepository;

public interface MySessionRepository extends CrudRepository<Session, Long> {
}

