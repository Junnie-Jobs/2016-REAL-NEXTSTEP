package org.nhnnext.nextstep.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.nextstep.core.AbstractEntity;
import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.session.MasterSession;
import org.nhnnext.nextstep.user.Instructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
@Entity
public class Course extends AbstractEntity {

	@NotEmpty
	private String name;

	private String description;

	@OneToOne
	private CourseSession defaultSession;

	@Column(unique = true)
	@ManyToMany
	private final List<Instructor> instructors = new ArrayList<>();

	// @Column(unique = true)
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", orphanRemoval
	// = true)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course") // (mappedBy =
																// "course",
																// fetch =
																// FetchType.LAZY)
	// @Cascade(CascadeType.ALL)
	private final List<Session> sessions = new ArrayList<>();

//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "course")
//	private MasterSession masterSession;

	public void addToSessions(CourseSession session) {
		this.getSessions().add(session);
		session.setCourse(this);
	}

//	public Course(MasterSession masterSession) {
//		this.masterSession = masterSession;
//	}

	// @Transient
	// public CourseSession getDefaultSession() {
	// return this.sessions.get(this.sessions.size()-1);
	// }
	//
	// @Transient
	// public List<Lecture> getDefaultLectures() {
	// return getDefaultSession().getLectures();
	// }
}
