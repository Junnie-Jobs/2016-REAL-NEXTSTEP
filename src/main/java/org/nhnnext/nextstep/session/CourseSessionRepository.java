package org.nhnnext.nextstep.session;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = CourseSessionExcerpt.class)
public interface CourseSessionRepository extends CrudRepository<Session, Long> {
}
