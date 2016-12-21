package org.nhnnext.nextstep.course;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.nextstep.core.domain.AbstractAuditingEntity;
import org.nhnnext.nextstep.core.domain.acls.AclImpl;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Course extends AbstractAuditingEntity<User, Long> {

    public Course(String name) {
    	Date dt = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); 
        addToSessions(new MasterSession(name));
        addToSessions(new CourseSession(name+"-"+sdf.format(dt).toString(), "default"));
        this.name = name;
    }

    @NotEmpty
    private String name;

    private String description;

//    @Column(unique = true)
//    @ManyToMany
//    private final List<Instructor> instructors = new ArrayList<>();

    public List<Instructor> getInstructors() {
        if (getCreatedBy() == null) {
            return Collections.unmodifiableList(Collections.EMPTY_LIST);
        }

        return Collections.unmodifiableList(Collections.singletonList((Instructor) getCreatedBy()));
    }

//    @Column(unique = true)
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", orphanRemoval = true)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "course")//(mappedBy = "course", fetch = FetchType.LAZY)
//    @Cascade(CascadeType.ALL)
    private final List<Session> sessions = new ArrayList<>();

    public Optional<Session> getSession(String role) {
        return getSessions().stream().filter(x -> Objects.equals(x.getRole(), role)).findFirst();
    }

    @Transient
    @JsonIgnore
    public Session getMasterSession() {
        return getSession("master").orElseGet(null);
    }

    @Transient
    @JsonIgnore
    public Session getDefaultSession() {
        return getSession("default").orElseGet(null);
    }
    
    public void addToSessions(Session session) {
        getSessions().add(session);
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