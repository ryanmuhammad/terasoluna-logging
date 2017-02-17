package org.ryan.logging.domain.repository.auditlog;

import org.ryan.logging.domain.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Repository
public interface AuditlogRepository extends JpaRepository<AuditLog,Long> {

}
