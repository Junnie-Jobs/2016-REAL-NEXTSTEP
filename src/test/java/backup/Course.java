package backup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Course extends AbstractPersistable<Long> {

	@NotNull
	private String name;

	private CourseState state;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Instructor> instructors = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<User> participants;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	@OrderColumn
	@JsonIgnore
	private List<Lecture> lectures = new ArrayList<>();

	void swapCourses(int i, int j) {
		Collections.swap(lectures, i, j);
	}
	
	public void addLecture(Lecture lecture){
		lectures.add(lecture);
	}
	
	public void addInstructor(Instructor instructor){
		instructors.add(instructor);
	}

	public Course() {
	}

	public Course(String name, CourseState state) {
		this.name = name;
		this.state = state;
	}

}
