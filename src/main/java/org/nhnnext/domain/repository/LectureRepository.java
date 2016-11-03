package org.nhnnext.domain.repository;

import java.util.List;

import org.nhnnext.domain.Instructor;
import org.nhnnext.domain.Lecture;
import org.nhnnext.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Long> {

	List<Lecture> findByInstructor(Instructor user);
}
