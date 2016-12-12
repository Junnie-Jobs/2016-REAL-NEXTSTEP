package org.nhnnext.nextstep.session;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.nextstep.core.AbstractEntity;
import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.lecture.Lecture;


@NoArgsConstructor(force = true)
@Data
@Entity
@ToString(exclude="course")
@EqualsAndHashCode(of="id")
@DiscriminatorValue("MASTER")
public class MasterSession extends AbstractEntity {

	@NotEmpty
	private String name;

	public MasterSession(String name) {
		this.name = name;
	}

	@OneToOne
	private Course course;
	
	@OneToMany(mappedBy = "masterSession")
//	@OrderColumn(name = "lecture_order")
	private List<Lecture> lectures;

}
