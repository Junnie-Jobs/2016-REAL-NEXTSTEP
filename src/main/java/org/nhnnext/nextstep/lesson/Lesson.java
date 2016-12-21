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
    
//    @JsonIgnore
//    @Transient
//    public Acl getAcl() {
//        MutableAcl acl = new AclImpl();
//        acl.insertAce(acl.getEntries().size(), BasePermission.READ, new GrantedAuthoritySid(GrantedAuthorities.ROLE_ANONYMOUS), true);
//        acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, new GrantedAuthoritySid(GrantedAuthorities.ROLE_INSTRUCTOR), true);
//        acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
//        acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
//        return acl;
//    }

}
