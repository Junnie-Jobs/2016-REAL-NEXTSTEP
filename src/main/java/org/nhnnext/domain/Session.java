package org.nhnnext.domain;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.domain.auditing.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
