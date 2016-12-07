package org.nhnnext.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.domain.auditing.AbstractPersistable;

import lombok.Data;

@Data
@Entity
public class Session extends AbstractPersistable<Long> {

	@NotEmpty
	private String title;

	@NotEmpty
	private String content;

	@ManyToOne(optional = false)
	private Lecture lecture; // should be final

	private Access access;

	public enum Access {
		PUBLIC,
		PRIVATE
	}
}
