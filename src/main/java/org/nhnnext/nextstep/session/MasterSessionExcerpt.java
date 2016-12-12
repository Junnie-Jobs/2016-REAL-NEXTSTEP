package org.nhnnext.nextstep.session;

import org.nhnnext.nextstep.course.Course;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = MasterSession.class)
public interface MasterSessionExcerpt {
	
	Long getId();
	Course getCourse();
	String getName();

}
