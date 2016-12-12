package org.nhnnext.nextstep.session;

import java.time.LocalDateTime;

import org.nhnnext.nextstep.course.Course;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "courseSession", types = CourseSession.class)
public interface CourseSessionExcerpt {
	
	Long getId();
	Course getCourse();
	String getName();
	LocalDateTime getStartDate();
	LocalDateTime getEndDate();
//	List<Enrollment> getEnrollments();
	
}
