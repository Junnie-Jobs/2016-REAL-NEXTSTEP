package org.nhnnext.nextstep.session;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.nhnnext.nextstep.core.ObjectConverter;
import org.nhnnext.nextstep.core.domain.AbstractAuditingEntity;
import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.course.domain.AbstractCourseEntity;
import org.nhnnext.nextstep.lecture.Lecture;
import org.nhnnext.nextstep.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
@Data
@Entity
@Inheritance
//@DiscriminatorColumn
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Session extends AbstractCourseEntity {

    @Convert(converter = ObjectConverter.class)
    private Object pos = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "session")//(mappedBy = "course", fetch = FetchType.LAZY)
//    @Cascade(CascadeType.ALL)
    private final List<Lecture> lectures = new ArrayList<>();

    public void addToLectures(Lecture lecture) {
        getLectures().add(lecture);
        lecture.setSession(this);
    }

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false) //(fetch = FetchType.EAGER) //(cascade = CascadeType.PERSIST)//(optional = false)
//    @Cascade(CascadeType.ALL)
//    @JoinColumn(name="COURSE_ID")
    private Course course;

//    public Session(String name) {
//        this.name = name;
//    }

    public boolean isInstructor(Authentication authentication) {
        Assert.notNull(getCourse());
        return getCourse().isInstructor(authentication);
    }
}
