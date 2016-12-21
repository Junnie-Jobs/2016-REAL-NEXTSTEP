package org.nhnnext.nextstep.discussion;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Discussion.class)
public interface DiscussionExcerpt {

    String getComment();
}