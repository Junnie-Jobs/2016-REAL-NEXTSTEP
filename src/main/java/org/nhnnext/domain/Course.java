package org.nhnnext.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Course extends AbstractPersistable<Long> {


	@NotNull
	private String name;

	private CourseState state;

	@ManyToOne
	@JsonBackReference
	private User instructor;

	@ManyToMany
	@JsonBackReference
	private Collection<User> participants;

	@OneToMany(mappedBy = "lecture")
	@OrderColumn
	private List<Lecture> courses;

	void swapCourses(int i, int j) {
		Collections.swap(courses, i, j);
	}

	public Course() {
	}

	public Course(String name, CourseState state, User instructor) {
		this.name = name;
		this.state = state;
		this.instructor = instructor;
	}

}
