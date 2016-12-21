package org.nhnnext.nextstep.session;

import lombok.Data;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.Authentication;

//@NoArgsConstructor(force = true)
@Data
@Entity
@DiscriminatorValue(SessionType.Values.MASTER)
public class MasterSession extends Session {

}
