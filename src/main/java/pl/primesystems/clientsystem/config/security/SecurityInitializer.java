package pl.primesystems.clientsystem.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletContext;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        servletContext.addFilter("encodingFilter", characterEncodingFilter).addMappingForUrlPatterns(null, false, "/*");

        super.beforeSpringSecurityFilterChain(servletContext);
    }
}
