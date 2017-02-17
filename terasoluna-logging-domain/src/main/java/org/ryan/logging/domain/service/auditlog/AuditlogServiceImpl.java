package org.ryan.logging.domain.service.auditlog;

import org.ryan.logging.domain.model.AuditLog;
import org.ryan.logging.domain.repository.auditlog.AuditlogRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Transactional
@Service
public class AuditlogServiceImpl implements AuditlogService {

    @Inject
    AuditlogRepository auditlogRepository;

    @Override
    public AuditLog register(AuditLog auditLog) {
        return auditlogRepository.saveAndFlush(auditLog);
    }

    @Override
    public AuditLog modify(AuditLog auditLog) {
        return auditlogRepository.saveAndFlush(auditLog);
    }

    @Override
    public void delete(AuditLog auditLog) {
        auditlogRepository.delete(auditLog);
    }

    @Override
    public AuditLog findOne(Long auditLogId) {
        return auditlogRepository.findOne(auditLogId);
    }

    @Override
    public List<AuditLog> findAll() {
        return auditlogRepository.findAll();
    }
}
