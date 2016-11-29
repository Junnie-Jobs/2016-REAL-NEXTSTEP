package org.nhnnext.domain.auditing;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.domain.Persistable;
import org.springframework.util.ClassUtils;

@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@MappedSuperclass
public abstract class AbstractPersistable<PK extends Serializable> implements Persistable<PK> {

	@Getter
	@Setter(AccessLevel.PROTECTED)
	@Id
	@GeneratedValue
	private PK id;

	@JsonIgnore
	@Transient
	public boolean isNew() {
		return null == getId();
	}
}
