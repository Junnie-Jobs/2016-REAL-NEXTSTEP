package org.nhnnext.nextstep.course;

import java.util.List;

import org.nhnnext.nextstep.session.SessionExcerpt;
import org.nhnnext.nextstep.user.Instructor;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Course.class)
public interface CourseExcerpt {

    Long getId();

    String getName();

    String getDescription();

    List<Instructor> getInstructors();

    List<SessionExcerpt> getSessions();

    SessionExcerpt getMasterSession();

    SessionExcerpt getDefaultSession();
    

    

}