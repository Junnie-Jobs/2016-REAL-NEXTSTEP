package org.nhnnext.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "excerpt", types = Session.class)
public interface SessionExcerpt {

	String getTitle();

	String getContent();
}
