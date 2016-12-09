package org.nhnnext.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude="lecture")
public class Lesson extends AbstractPersistable<Long> {

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
