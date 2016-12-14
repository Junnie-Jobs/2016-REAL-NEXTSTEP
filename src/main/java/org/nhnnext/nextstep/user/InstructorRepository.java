package org.nhnnext.nextstep.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = UserExcerpt.class)
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
}
