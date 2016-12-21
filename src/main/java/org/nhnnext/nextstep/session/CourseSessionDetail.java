package org.nhnnext.nextstep.session;

import org.nhnnext.nextstep.lecture.LectureExcerpt;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "detail", types = CourseSession.class)
public interface CourseSessionDetail {

    String getName();

    String getDescription();

    List<LectureExcerpt> getLectures();

    Object getPos();

    CourseSession.State getState();
}