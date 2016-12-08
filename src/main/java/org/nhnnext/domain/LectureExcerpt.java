package org.nhnnext.domain;

import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Lecture.class)
public interface LectureExcerpt {

	String getTitle();

	List<Lesson> getLessons();
}
