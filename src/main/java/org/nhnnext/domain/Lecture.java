package org.nhnnext.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.AbstractPersistable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
public class Lecture extends AbstractPersistable<Long> {

	@NotNull
	private String title;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_course_id"))
	@JsonBackReference
	private Course course;
	
	@OneToMany(mappedBy = "lecture")
	@OrderColumn
	@JsonManagedReference
	private List<Session> sessions = new ArrayList<>();
	
	public void addSession(Session session){
		sessions.add(session);
	}
	
	public Lecture(){}
	
	public Lecture(String title, Course course){
		this.title = title;
		course.addLecture(this);
	}
}

