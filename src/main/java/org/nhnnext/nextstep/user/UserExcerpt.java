package org.nhnnext.nextstep.user;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = User.class)
public interface UserExcerpt {

    Long getId();

    String getUsername();

    String getName();

    String getAvatarUrl();

    String getRole();
}
