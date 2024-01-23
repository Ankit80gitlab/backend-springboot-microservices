package com.cms.productapplication.interceptor;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {
    private String defaultTenant ="public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String t =  TenantContext.getCurrentTenant();
        //System.out.println(t);
        //System.out.println("called - resolve current tenant identifier");
        if(t!=null){
            //System.out.println(t);
            return t;
        } else {
            //System.out.println(defaultTenant);
            return defaultTenant;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}
