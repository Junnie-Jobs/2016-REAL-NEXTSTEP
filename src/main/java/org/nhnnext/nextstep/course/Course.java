package org.nhnnext.nextstep.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.nhnnext.nextstep.core.domain.AbstractAuditingEntity;
import org.nhnnext.nextstep.core.domain.acls.AclImpl;
import org.nhnnext.nextstep.lecture.Lecture;
import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.session.MasterSession;
import org.nhnnext.nextstep.session.Session;
import org.nhnnext.nextstep.user.AuthenticationUtils;
import org.nhnnext.nextstep.user.GrantedAuthorities;
import org.nhnnext.nextstep.user.Instructor;
import org.nhnnext.nextstep.user.User;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.Authentication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(force = true)
@Data
@Entity
public class Course extends AbstractAuditingEntity<User, Long> {

    //    @NotEmpty
    private String name;

    private String description;
    
    @OneToOne
	private CourseSession defaultSession;
    
//    @Column(unique = true)
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private final List<Instructor> instructors = new ArrayList<>();
    
//  @Column(unique = true)
//  @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", orphanRemoval = true)
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL)//(mappedBy = "course", fetch = FetchType.LAZY)
    private final List<Session> sessions = new ArrayList<>();

    public List<Instructor> getInstructors() {
        if (getCreatedBy() == null) {
            return Collections.unmodifiableList(Collections.EMPTY_LIST);
        }

        return Collections.unmodifiableList(Collections.singletonList((Instructor) getCreatedBy()));
    }
    


    public void addToSessions(Session session) {
        this.getSessions().add(session);
        session.setCourse(this);
    }
    

    public boolean isInstructor(Authentication authentication) {
        return getInstructors().contains(AuthenticationUtils.getUser(authentication));
    }

    @JsonIgnore
    @Transient
    public List<Sid> getSids(Authentication authentication) {
        List<Sid> sids = new ArrayList<>();

        if (isInstructor(authentication)) {
            sids.add(new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR));
        }

        return sids;
    }

    @JsonIgnore
    @Transient
    public Acl getAcl() {
        MutableAcl acl = new AclImpl();
        acl.insertAce(acl.getEntries().size(), BasePermission.READ, new GrantedAuthoritySid(GrantedAuthorities.ROLE_ANONYMOUS), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, new GrantedAuthoritySid(GrantedAuthorities.ROLE_INSTRUCTOR), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
        return acl;
    }
}
