package org.nhnnext.nextstep.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.nhnnext.nextstep.session.MasterSession;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = { User.class, Instructor.class })
public interface UserExcerpt {

    String getName();
    String getEmail();
    String getAvatarUrl();
}
