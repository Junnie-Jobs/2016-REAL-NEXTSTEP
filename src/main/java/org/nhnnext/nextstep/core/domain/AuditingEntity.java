package org.nhnnext.nextstep.core.domain;

import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.util.List;

public interface AuditingEntity<U, ID extends Serializable> extends Auditable<U, ID>  {

	boolean isCreatedBy(final U createdBy);

	List<Sid> getSids(Authentication authentication);

	Acl getAcl();
}
