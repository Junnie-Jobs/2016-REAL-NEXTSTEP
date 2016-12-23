package org.nhnnext.nextstep.discussion.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.nhnnext.nextstep.core.domain.acls.AclImpl;
import org.nhnnext.nextstep.lesson.domain.AbstractLessonEntity;
import org.nhnnext.nextstep.user.GrantedAuthorities;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.MutableAcl;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AbstractDiscussionEntity extends AbstractLessonEntity {

    @JsonIgnore
    @Transient
    public Acl getAcl() {
        MutableAcl acl = new AclImpl();

        if (isPublic()) {
            acl.insertAce(acl.getEntries().size(), BasePermission.READ, new GrantedAuthoritySid(GrantedAuthorities.ROLE_ANONYMOUS), true);
        }

        acl.insertAce(acl.getEntries().size(), BasePermission.READ, new GrantedAuthoritySid(GrantedAuthorities.COURSE_PARTICIPANT), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.READ, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_PARTICIPANT), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, new GrantedAuthoritySid(GrantedAuthorities.ENTITY_OWNER), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, new GrantedAuthoritySid(GrantedAuthorities.ENTITY_OWNER), true);
        return acl;
    }
}
