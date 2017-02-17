package org.ryan.logging.app.user;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Data
@ToString
public class UserForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String username;

    @NotEmpty
    private String email;

    @NotEmpty
    private String address;

    public UserForm(){}

}
