package org.nhnnext.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.nhnnext.domain.auditing.AbstractPersistable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
	private List<Lesson> lessons;
	
	private int pos;
	
}
