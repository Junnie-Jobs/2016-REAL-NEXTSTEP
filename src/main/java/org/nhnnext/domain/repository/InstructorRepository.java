package org.nhnnext.domain.repository;

import org.nhnnext.domain.Discussion;
import org.nhnnext.domain.Instructor;
import org.nhnnext.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {

	Instructor findByNickname(String nickname);

	void save(User u1);

}
