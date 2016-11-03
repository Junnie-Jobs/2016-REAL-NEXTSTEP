package org.nhnnext.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Student extends User{
	
	@ManyToMany
	private List<Lecture> lectures;
		
	public Student(String name, String nickname, String profile, int level) {
		super(name, nickname, profile, level);
	}

	public Student() {
		
	}

}
