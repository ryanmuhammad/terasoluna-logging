package org.ryan.logging.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Data
@Entity
@Table(name = "t_auditlog")
public class AuditLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @NotNull
    @Column(name = "audit_log_id")
    private String auditLogId;

    @NotNull
    @Column
    private String action;

    @Column
    private String detail;

    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "entity_id")
    private String entityId;

    @NotNull
    @Column(name = "entity_name")
    private String entityName;

    public AuditLog() {}

}
