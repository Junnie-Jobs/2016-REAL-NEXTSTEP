package org.nhnnext.nextstep.session;

import java.time.LocalDateTime;
import java.util.List;

import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.enrollment.Enrollment;
import org.nhnnext.nextstep.enrollment.EnrollmentExcerpt;
import org.nhnnext.nextstep.lecture.Lecture;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = CourseSession.class)
public interface CourseSessionExcerpt {
	
	Long getId();
	Course getCourse();
	String getName();
	String getPos();
	LocalDateTime getStartDate();
	LocalDateTime getEndDate();
	List<Lecture> getLectures();
	List<EnrollmentExcerpt> getEnrollments();
	
}
