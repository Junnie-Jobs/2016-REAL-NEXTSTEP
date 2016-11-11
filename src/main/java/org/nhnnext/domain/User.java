package org.nhnnext.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class User extends AbstractPersistable<Long> {

	@NotNull
	private String name;
	
	private String nickname;
	
	private String profile;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="instructors")
	@JsonIgnore
	private List<Course> makeCourses = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="participants")
	@JsonIgnore
	private List<Course> takeCourses = new ArrayList<>();
	
	public User(){}
	
	public User(String name, String nickname, String profile) {
		this.name = name;
		this.nickname = nickname;
		this.profile = profile;
	}

	public void addCourse(Course course) {
		makeCourses.add(course);
	}
	
	public void addTakeCourse(Course course) {
		takeCourses.add(course);
	}
	
}
