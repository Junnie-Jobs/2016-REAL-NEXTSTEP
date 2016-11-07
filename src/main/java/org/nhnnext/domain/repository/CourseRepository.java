package org.nhnnext.domain.repository;

import java.util.List;

import org.nhnnext.domain.Course;
import org.nhnnext.domain.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
	List<Course> findByInstructor(Instructor user);
}
