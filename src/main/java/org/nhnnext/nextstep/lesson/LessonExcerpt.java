package org.nhnnext.nextstep.lesson;

import org.nhnnext.nextstep.lecture.Lecture;
import org.nhnnext.nextstep.lesson.Lesson.Access;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Lesson.class)
public interface LessonExcerpt {

	Long getId();
	String getTitle();
	String getContent();
//	Lecture getLecture();
	Access getAccess();
}
