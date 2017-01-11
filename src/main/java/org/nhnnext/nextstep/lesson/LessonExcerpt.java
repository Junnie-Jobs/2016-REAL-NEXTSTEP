package org.nhnnext.nextstep.lesson;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.nhnnext.nextstep.discussion.Discussion;
import org.nhnnext.nextstep.lecture.Lecture;
import org.nhnnext.nextstep.lesson.Lesson.Access;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Lesson.class)
public interface LessonExcerpt {

    Long getId();
    
    String getContent();
    
    Lecture getLecture();

    String getName();
    
    Access getAcess();

    List<Discussion> getDiscussions();

}