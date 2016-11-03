package org.nhnnext.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Instructor extends User{
	
	@OneToMany(mappedBy = "instructor")
	private List<Lecture> lectures;
	
	public Instructor(){}
	
	public Instructor(String name, String nickname, String profile, int level) {
		super(name, nickname, profile, level);
	}
	
}
