package org.example.SpringBootApp.filter;

import org.keycloak.adapters.AdapterDeploymentContext;
import org.keycloak.adapters.AuthenticatedActionsHandler;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.OIDCHttpFacade;
import org.keycloak.adapters.spi.HttpFacade;
import org.keycloak.adapters.springsecurity.facade.SimpleHttpFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class KeycloakResourcePermissionAuthorizationFilter extends OncePerRequestFilter {


    private ApplicationContext applicationContext;

    @Autowired
    public KeycloakResourcePermissionAuthorizationFilter(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    private AdapterDeploymentContext adapterDeploymentContext;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String httpMethod = request.getMethod();
        String httpAuthType = request.getAuthType();
        String httpAuthTokenWithBearer = request.getHeader("Authorization");
        String requestURI = request.getRequestURI();
        String requestURL = request.getRequestURL().toString();
        System.out.println("filter for keycloak permission");
        HttpFacade facade = new SimpleHttpFacade(request, response);
        KeycloakDeployment deployment = getAdapterDeploymentContext().resolveDeployment(facade);
        OIDCHttpFacade oidcFacade = OIDCHttpFacade.class.cast(facade);
        AuthenticatedActionsHandler authenticatedActionsHandler = new AuthenticatedActionsHandler(deployment, oidcFacade);
        boolean authorized = authenticatedActionsHandler.handledRequest();
        filterChain.doFilter(request,response);
    }

    private AdapterDeploymentContext getAdapterDeploymentContext() {
        if(null == adapterDeploymentContext) {
            adapterDeploymentContext = applicationContext.getBean(AdapterDeploymentContext.class);
        }
        return adapterDeploymentContext;
    }
}
