package org.nhnnext.nextstep.lesson;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.nextstep.core.domain.AbstractEntity;
import org.nhnnext.nextstep.course.domain.AbstractCourseEntity;
import org.nhnnext.nextstep.lecture.Lecture;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;

import lombok.Data;

@Data
@Entity
public class Lesson extends AbstractCourseEntity {

    @NotNull
    private Access access = Access.PRIVATE;

    public enum Access {
        PUBLIC,
        PRIVATE
    }

    @NotEmpty
    private String name;

//    @NotEmpty
    private String content;

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    private Lecture lecture;
    
    public boolean isInstructor(Authentication authentication) {
        Assert.notNull(getLecture());
        return getLecture().isInstructor(authentication);
    }
    
}
