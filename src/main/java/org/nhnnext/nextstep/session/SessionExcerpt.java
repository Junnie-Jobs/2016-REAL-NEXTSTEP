package org.nhnnext.nextstep.session;

import java.util.ArrayList;
import java.util.List;

import org.nhnnext.nextstep.lecture.Lecture;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Session.class)
public interface SessionExcerpt {

    Long getId();

    String getName();

    String getDescription();
    
    List<Lecture> getLecutres();
    
    ArrayList<Object> getLecturePos();
    
}