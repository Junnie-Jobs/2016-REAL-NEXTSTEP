package org.nhnnext.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.nhnnext.domain.auditing.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString(exclude="course")
@EqualsAndHashCode(of="id")
@Entity
public class Lecture extends AbstractPersistable<Long> {

	@NotNull
	private String title;

	@ManyToOne(optional = false)
	private Course course;

	@OneToMany(mappedBy = "lecture", cascade = CascadeType.MERGE)
//	@OrderColumn(name = "course_order")
	private List<Session> sessions;
}
