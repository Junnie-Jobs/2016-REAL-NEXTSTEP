package org.nhnnext.nextstep.course;
import java.util.List;

import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.session.CourseSessionExcerpt;
import org.nhnnext.nextstep.session.MasterSession;
import org.nhnnext.nextstep.user.UserExcerpt;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Course.class)
public interface CourseExcerpt {
	
	Long getId();
	String getName();
	String getDescription();
	List<UserExcerpt> getInstructors();
	MasterSession getMasterSession();	
	List<CourseSessionExcerpt> getSessions();
	CourseSession getDefaultSession();
	
	
}
