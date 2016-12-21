package org.nhnnext.nextstep.course;

import java.util.List;

import org.nhnnext.nextstep.session.SessionDetail;
import org.nhnnext.nextstep.session.SessionExcerpt;
import org.nhnnext.nextstep.user.Instructor;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "detail", types = Course.class)
public interface CourseDetail {

    String getName();

    String getDescription();

    List<Instructor> getInstructors();

    List<SessionExcerpt> getSessions();

    SessionDetail getMasterSession();

    SessionDetail getDefaultSession();
}