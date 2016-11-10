package org.nhnnext.domain.repository;

import java.util.ArrayList;

import org.nhnnext.domain.Course;
import org.nhnnext.domain.Lecture;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Long> {

	ArrayList<Lecture> findByCourse(Course course);

	
}
