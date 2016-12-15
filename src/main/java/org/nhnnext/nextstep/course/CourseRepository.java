package org.nhnnext.nextstep.course;

import org.nhnnext.nextstep.course.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = CourseExcerpt.class)
public interface CourseRepository extends CrudRepository<Course, Long> {
}
