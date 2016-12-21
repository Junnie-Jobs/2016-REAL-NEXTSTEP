package org.nhnnext.nextstep.session;

import java.time.LocalDateTime;
import java.util.List;

import org.nhnnext.nextstep.enrollment.EnrollmentExcerpt;
import org.nhnnext.nextstep.lecture.LectureExcerpt;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = CourseSession.class)
public interface CourseSessionExcerpt {
	
	   List<EnrollmentExcerpt> getEnrollments();
	   Long getId();

	    String getName();

	    String getDescription();
	    
		List<LectureExcerpt> getLectures();
		
		String getRole();
		
//		ArrayList<Object> getPos();
		Object getPos();
		
		LocalDateTime getStartDate();
		LocalDateTime getEndDate();

}
