package org.nhnnext.nextstep.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.nhnnext.nextstep.course.Course;

@NoArgsConstructor(force = true)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("INSTRUCTOR")
public class Instructor extends User {

    public Instructor(String username) {
        super(username);
    }

    @JsonIgnore
    @Transient
    public String getRole() {
        return GrantedAuthorities.ROLE_INSTRUCTOR;
    }

//  @OneToMany(mappedBy = "createdBy")
//    @Column(unique = true)
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "instructors")
//    private final List<Course> courses = new ArrayList<>();

    //    private final List<Session> sessions = new ArrayList<>();
}
