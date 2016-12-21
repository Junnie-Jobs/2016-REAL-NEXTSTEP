package org.nhnnext.nextstep.course;

import java.util.List;

import org.nhnnext.nextstep.session.CourseSessionDetail;
import org.nhnnext.nextstep.session.CourseSessionExcerpt;
import org.nhnnext.nextstep.session.MasterSessionDetail;
import org.nhnnext.nextstep.user.Instructor;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "detail", types = Course.class)
public interface CourseDetail {
	
	Long getId();

	String getName();

	String getDescription();

	List<Instructor> getInstructors();

	List<CourseSessionExcerpt> getCourseSessions();

	MasterSessionDetail getMasterSession();

	CourseSessionDetail getDefaultSession();
}