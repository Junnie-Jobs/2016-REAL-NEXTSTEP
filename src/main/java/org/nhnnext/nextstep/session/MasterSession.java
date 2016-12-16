package org.nhnnext.nextstep.session;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.lecture.Lecture;
import org.nhnnext.nextstep.user.GrantedAuthorities;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor(force = true)
@Data
@Entity
@ToString(exclude="course")
@EqualsAndHashCode(of="id")
@DiscriminatorValue("MASTER")
public class MasterSession extends Session {

	@OneToOne
	private Course course;
	
	@NotEmpty
	private String name;

	public MasterSession(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "masterSession")
//	@OrderColumn(name = "lecture_order")
	private List<Lecture> lectures;
	
	public void addToLectures(Lecture lecture) {
		lectures.add(lecture);
		lecture.setMasterSession(this);
	}
	
}
