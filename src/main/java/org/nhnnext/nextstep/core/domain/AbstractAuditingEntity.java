package org.nhnnext.nextstep.core.domain;

import java.io.Serializable;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity<U, PK extends Serializable> extends AbstractAuditable<U, PK> implements AuditingEntity<U, PK> {

	@JsonIgnore
	@Transient
	public boolean isCreatedBy(U createdBy) {
		return getCreatedBy() != null && getCreatedBy().equals(createdBy);

	}
}
