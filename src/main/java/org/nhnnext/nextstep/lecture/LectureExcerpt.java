package org.nhnnext.nextstep.lecture;

import java.util.List;

import org.nhnnext.nextstep.lesson.Lesson;
import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.session.MasterSession;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Lecture.class)
public interface LectureExcerpt {
	
	Long getId();
	String getTitle();
	CourseSession getCourseSession();
	MasterSession getMasterSession();
	List<Lesson> getLessons();
	String getPos();
}
