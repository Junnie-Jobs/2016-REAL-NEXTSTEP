package org.nhnnext.nextstep.session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.nhnnext.nextstep.core.ObjectConverter;
import org.nhnnext.nextstep.core.domain.AbstractAuditingEntity;
import org.nhnnext.nextstep.core.domain.acls.AclImpl;
import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.lecture.Lecture;
import org.nhnnext.nextstep.user.GrantedAuthorities;
import org.nhnnext.nextstep.user.User;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
@Entity
@Inheritance
public class Session extends AbstractAuditingEntity<User, Long> {

    @Convert(converter = ObjectConverter.class)
    private Object pos = new ArrayList<Object>();

    @NotNull
    private State state = State.IN_SESSION;
    
	private LocalDateTime startDate;
    private LocalDateTime endDate;

    public enum State {
        UPCOMING, IN_SESSION
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "session")
    private final List<Lecture> lectures = new ArrayList<>();

    public void addToLectures(Lecture lecture) {
        getLectures().add(lecture);
        lecture.setSession(this);
    }

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    private Course course;

    @Column(unique = true, nullable = false)
    private final String name;
    
    public Session(String name, String role){
    	this.name = name;
    	this.role = role;
    }
    
    private String role;
    
    private String description;

    public boolean isInstructor(Authentication authentication) {
        Assert.notNull(getCourse());
        return getCourse().isInstructor(authentication);
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
        acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, new GrantedAuthoritySid(GrantedAuthorities.COURSE_INSTRUCTOR), true);
        return acl;
    }
    
  
}
