package org.nhnnext.nextstep.lecture;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.nhnnext.nextstep.lesson.Lesson;
import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.session.MasterSession;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor(force = true)
@ToString(exclude="course")
@EqualsAndHashCode(of="id")
@Entity
public class Lecture extends AbstractPersistable<Long>{
	
	@NotNull
	private String title;

	@ManyToOne
	private CourseSession courseSession;
	
	@ManyToOne	
	private MasterSession masterSession;
	
	@OneToMany(mappedBy = "lecture", cascade = CascadeType.MERGE)
//	@OrderColumn(name = "course_order")
	private List<Lesson> lessons;
	
	private String pos;
	
	
	public Lecture(String title){
		this.title = title;
	}
}
