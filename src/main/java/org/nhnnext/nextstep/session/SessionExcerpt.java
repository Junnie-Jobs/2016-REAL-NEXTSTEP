package org.nhnnext.nextstep.session;

import java.time.LocalDateTime;
import java.util.List;

import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.enrollment.Enrollment;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = SessionExcerpt.class)
public interface SessionExcerpt {
	
	Long getId();
	Course getCourse();
	String getName();
	LocalDateTime getStartDate();
	LocalDateTime getEndDate();
	List<Enrollment> getEnrollments();
	
}
