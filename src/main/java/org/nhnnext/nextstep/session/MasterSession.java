package org.nhnnext.nextstep.session;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

@NoArgsConstructor(force = true)
@Data
@Entity
@DiscriminatorValue("MASTER")
public class MasterSession extends Session {
	
    public MasterSession(String name) {
        this.name = name;
    }

    @NotEmpty
    private String name;

}
