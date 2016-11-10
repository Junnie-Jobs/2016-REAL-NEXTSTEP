package org.nhnnext.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
public class User extends AbstractPersistable<Long> {

	@NotNull
	@JsonIgnore
	private String name;
	
	@JsonIgnore
	private String nickname;
	
	@JsonIgnore
	private String profile;
	
	@JsonIgnore
	private int level;
	
	@ManyToMany(mappedBy="instructors")
	@JsonIgnore
	private List<Course> courses = new ArrayList<>();
	
	public User(){}
	
	public User(String name, String nickname, String profile, int level) {
		this.name = name;
		this.nickname = nickname;
		this.profile = profile;
		this.level = level;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}
//	, fetch = FetchType.LAZY, cascade = CascadeType.ALL
}
