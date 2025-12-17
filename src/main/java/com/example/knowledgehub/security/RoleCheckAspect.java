package com.example.knowledgehub.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RoleCheckAspect {
    @Before("@annotation(requiresRole)")
    public void checkRole(RequiresRole requiresRole) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String userRole = request.getHeader("User-Role");

        if (userRole == null || !userRole.equalsIgnoreCase(requiresRole.value())) {
            throw new RuntimeException("Access Denied: You must be " + requiresRole.value());
        }
    }
}