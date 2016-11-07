package org.nhnnext.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Lecture extends AbstractPersistable<Long> {

	@NotNull
	private String title;

	@ManyToOne
	private Course lecture;
}
