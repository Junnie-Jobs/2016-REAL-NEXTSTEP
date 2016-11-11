package org.nhnnext.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;

@Data
@Entity
public class SessionComment extends AbstractPersistable<Long> {

	@NotNull
	private String comment;

	@ManyToOne
	private Session session;
}
