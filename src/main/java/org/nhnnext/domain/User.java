package org.nhnnext.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;

@Data
@Entity
public class User extends AbstractPersistable<Long> {

	@NotNull
	private String name;
	
	private String nickname;
	
	private String profile;
	
	private int level;
	
	@ManyToMany
	private List<Course> lectures;
	
	public User(){}
	
	public User(String name, String nickname, String profile, int level) {
		this.name = name;
		this.nickname = nickname;
		this.profile = profile;
		this.level = level;
	}
}
