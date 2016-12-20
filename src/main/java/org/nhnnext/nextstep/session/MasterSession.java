package org.nhnnext.nextstep.session;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.lecture.Lecture;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(force = true)
@Data
@Entity
@EqualsAndHashCode(of="id")
@DiscriminatorValue("MASTER")
public class MasterSession extends Session {

}
