package org.nhnnext.nextstep.lesson;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.nextstep.lecture.Lecture;
import org.springframework.data.jpa.domain.AbstractPersistable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@Entity
@ToString(exclude="lecture")
public class Lesson extends AbstractPersistable<Long>{
	
	@NotEmpty
	private String title;

//	@NotEmpty
	private String content;

	@ManyToOne
	private Lecture lecture; // should be final

	private Access access;

	public enum Access {
		PUBLIC,
		PRIVATE
	}
	
	public Lesson(String title){
		this.title = title;
	}
	
	
}
