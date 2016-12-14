package org.nhnnext.nextstep.enrollment;

import org.nhnnext.nextstep.enrollment.Enrollment.Status;
import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.user.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "courseSession", types = Enrollment.class)
public interface EnrollmentExcerpt {

	Long getId();
	Status getStatue();
	CourseSession getSession();
	User getUser();

	    
	
}
