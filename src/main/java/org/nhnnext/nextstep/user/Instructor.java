package org.nhnnext.nextstep.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @Transient
    public String getRole() {
        return GrantedAuthorities.ROLE_INSTRUCTOR;
    }
    


//    @OneToMany(mappedBy = "createdBy")
//    private final List<Course> courses = new ArrayList<>();
//    
//    @Transient
//    public List<Course> getCourses(){
//    	return this.courses;
//    }

    //    private final List<Session> sessions = new ArrayList<>();
}
