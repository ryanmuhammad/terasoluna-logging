package org.ryan.logging.domain.service.auditlog;

import org.ryan.logging.domain.model.AuditLog;

import java.util.List;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
public interface AuditlogService {

    AuditLog register(AuditLog auditLog);
    AuditLog modify(AuditLog auditLog);
    void delete(AuditLog auditLog);
    AuditLog findOne(Long auditLogId);
    List<AuditLog> findAll();

}
