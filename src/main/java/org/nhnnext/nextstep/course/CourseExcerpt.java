package org.nhnnext.nextstep.course;
import org.springframework.data.rest.core.config.Projection;
import java.util.List;

import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.session.MasterSession;
import org.nhnnext.nextstep.user.Instructor;

@Projection(name = "excerpt", types = Course.class)
public interface CourseExcerpt {
	
	Long getId();
	String getName();
	String getDescription();
	List<Instructor> getInstructors();
	MasterSession getMasterSession();
	List<CourseSession> getSessions();
}
