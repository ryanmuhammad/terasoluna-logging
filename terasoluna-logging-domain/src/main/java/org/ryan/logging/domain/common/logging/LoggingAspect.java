package org.ryan.logging.domain.common.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.ryan.logging.domain.model.AuditLog;
import org.ryan.logging.domain.model.User;
import org.ryan.logging.domain.service.auditlog.AuditlogService;

import javax.inject.Inject;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Aspect
public class LoggingAspect {

    @Inject
    AuditlogService auditlogService;

    @AfterReturning(value = "@annotation(auditable)",returning = "result")
    public void log(JoinPoint joinPoint, Auditable auditable, Object result) throws IOException, IllegalAccessException, NoSuchFieldException {

        Class<?> clazz = result.getClass();
        Field[] fields = clazz.getDeclaredFields();
        fields[1].setAccessible(true);

        Field field = clazz.getDeclaredField("email");
        field.setAccessible(true);
        System.out.println("* email : "+field.get(result));

        System.out.println("* id : "+fields[1].get(result));
        System.out.println("* Signature : " + joinPoint.getSignature().getName());
        System.out.println("* Source location : " + joinPoint.getSourceLocation().getClass());
        System.out.println("* Target : " + joinPoint.getTarget().getClass());

        ObjectMapper mapper = new ObjectMapper();

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        String action = joinPoint.getSignature().getName();
        String detail = mapper.writeValueAsString(result);
        Object entityId = fields[1].get(result);
        String entityName = result.getClass().toString();

        AuditLog auditLog = new AuditLog();
        auditLog.setAction(action);
        auditLog.setDetail(detail);
        auditLog.setCreatedDate(currentTime);
        auditLog.setUserId(1L);
        auditLog.setEntityId(String.valueOf(entityId));
        auditLog.setEntityName(entityName);
        auditlogService.register(auditLog);

        System.out.println("* json : " + detail);
        System.out.println("* result : " + result);
        System.out.println("* result.getClass : " + result.getClass().toString());

        //JSON from String to Object
        User user = mapper.readValue(detail, User.class);
        System.out.println("* Object name : "+user.getName());
        System.out.println("* Object email : "+user.getEmail());

    }

}
