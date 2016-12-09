package org.nhnnext.repository;

import org.nhnnext.domain.SecurityUser;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface SecurityUserRepository extends Repository<SecurityUser, Long> {

	SecurityUser save(SecurityUser manager);

	SecurityUser findByName(String name);

}
