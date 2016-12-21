package org.nhnnext.nextstep.session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.nhnnext.nextstep.enrollment.EnrollmentExcerpt;
import org.nhnnext.nextstep.lecture.LectureExcerpt;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Session.class)
public interface SessionExcerpt {

    Long getId();

    String getName();

    String getDescription();
    
	List<LectureExcerpt> getLectures();
	
	String getRole();
	
//	ArrayList<Object> getPos();
	Object getPos();
	
	    
}