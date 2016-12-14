package org.nhnnext.nextstep.session;

import java.time.LocalDateTime;
import java.util.List;

import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.lecture.Lecture;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "courseSession", types = CourseSession.class)
public interface CourseSessionExcerpt {
	
	Long getId();
	Course getCourse();
	String getName();
	String getPos();
	LocalDateTime getStartDate();
	LocalDateTime getEndDate();
	List<Lecture> getLectures();
//	List<Enrollment> getEnrollments();
	
}
