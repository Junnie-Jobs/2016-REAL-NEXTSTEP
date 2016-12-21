package org.nhnnext.nextstep.config;

import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.lecture.Lecture;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomizedRestMvcConfiguration extends RepositoryRestConfigurerAdapter{

	 @Override
	  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		 config.exposeIdsFor(Course.class);
		 config.exposeIdsFor(Lecture.class);
	  }
}
