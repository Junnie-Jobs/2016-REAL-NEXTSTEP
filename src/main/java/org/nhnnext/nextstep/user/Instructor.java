package org.nhnnext.nextstep.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
@Entity
@DiscriminatorValue("INSTRUCTOR")
public class Instructor extends User {

	public Instructor(String username) {
		super(username);
	}


	//	@Column(unique = true)
//	@ManyToMany(mappedBy = "instructors")
//	private final List<Course> courses = new ArrayList<>();

	// private final List<Session> sessions = new ArrayList<>();
}
