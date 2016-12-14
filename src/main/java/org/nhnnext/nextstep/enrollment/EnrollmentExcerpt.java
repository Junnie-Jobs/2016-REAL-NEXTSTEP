package org.nhnnext.nextstep.enrollment;

import org.nhnnext.nextstep.enrollment.Enrollment.Status;
import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.user.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Enrollment.class)
public interface EnrollmentExcerpt {

	Long getId();
	Status getStatus();
	CourseSession getSession();
	User getUser();

	    
	
}
