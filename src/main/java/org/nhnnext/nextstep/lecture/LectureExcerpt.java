package org.nhnnext.nextstep.lecture;

import java.util.List;

import org.nhnnext.nextstep.lesson.LessonExcerpt;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Lecture.class)
public interface LectureExcerpt {

    Long getId();

    String getName();

    List<LessonExcerpt> getLessons();
    
//    ArrayList<Object> getPos();
    Object getPos();
}