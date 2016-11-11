package org.nhnnext.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Course extends AbstractPersistable<Long> {

	@NotNull
	private String name;

	private CourseState state;
	
	@Lob // DB BLOB, CLOB 타입과 매
	private String description;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name="course_of_instructors", 
				joinColumns = @JoinColumn(name="course_id"), 
				inverseJoinColumns = @JoinColumn (name = "user_id"))
	@JsonIgnore
	private Collection<User> instructors = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name="course_of_participants", 
				joinColumns = @JoinColumn(name="course_id"), 
				inverseJoinColumns = @JoinColumn (name = "user_id"))
	@JsonIgnore
	private Collection<User> participants = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "course")
	@OrderColumn
	@JsonManagedReference
	private List<Lecture> lectures = new ArrayList<>();

	void swapCourses(int i, int j) {
		Collections.swap(lectures, i, j);
	}
	
	public void addLecture(Lecture lecture){
		lectures.add(lecture);
	}
	
	public void addInstructor(User user){
		instructors.add(user);
		user.addCourse(this);
	}
	
	public void addParticipant(User user){
		participants.add(user);
	}

	public Course() {
	}

	public Course(String name, CourseState state, User user) {
		this.name = name;
		this.state = state;
		this.addInstructor(user);
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", state=" + state + ", description=" + description + ", lectures=" + lectures + "]";
	}
	
	

}
