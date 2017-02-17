package org.ryan.logging.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @NotNull
    @Column(name = "user_id")
    private String userId;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String address;

    public User() {}

}
