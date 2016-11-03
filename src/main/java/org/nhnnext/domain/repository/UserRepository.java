package org.nhnnext.domain.repository;

import org.nhnnext.domain.Instructor;
import org.nhnnext.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByNickname(String nickname);
}
