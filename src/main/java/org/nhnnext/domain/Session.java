package org.nhnnext.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.nhnnext.domain.acls.AclImpl;
import org.nhnnext.domain.auditing.AbstractPersistable;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Session extends AbstractPersistable<Long> {

	@NotNull
	private String name;

	private State state;

	@Lob
	private String description;

	@ManyToMany
	private Collection<User> instructors;

	@ManyToMany
	private Collection<User> participants;

	@OneToMany(mappedBy = "course")
//	@OrderColumn(name = "lecture_order")
	private List<Lecture> lectures;
	
	void swapLecture(int i, int j) {
		Collections.swap(lectures, i, j);
	}

	public enum State {
		UPCOMING,
		IN_SESSION
	}

	public boolean isInstructor(Authentication authentication) {
		return true;
	}

	public boolean isMember(Authentication authentication) {
		return true;
	}

	public List<Sid> getSids(Authentication authentication) {
		List<Sid> sids = new ArrayList<>();

		sids.add(new PrincipalSid(authentication));

		if (isMember(authentication)) {
			sids.add(new GrantedAuthoritySid("COURSE_MEMBER"));
		}

		if (isInstructor(authentication)) {
			sids.add(new GrantedAuthoritySid("COURSE_INSTRUCTOR"));
		}

		return sids;
	}

	@JsonIgnore
	@Transactional
	public Acl getAcl() {
		MutableAcl acl = new AclImpl();
		acl.insertAce(acl.getEntries().size(), BasePermission.READ, new GrantedAuthoritySid("ROLE_GUEST"), true);
		acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, new GrantedAuthoritySid("ROLE_INSTRUCTOR"), true);
		acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, new GrantedAuthoritySid("COURSE_INSTRUCTOR"), true);
		acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, new GrantedAuthoritySid("COURSE_INSTRUCTOR"), true);
		return acl;
	}
}
