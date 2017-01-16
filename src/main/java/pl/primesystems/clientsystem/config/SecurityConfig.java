package pl.primesystems.clientsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.primesystems.clientsystem.user.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/register").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login").permitAll()
                        .loginProcessingUrl("/login-process").permitAll()
                            .usernameParameter("email")
                            .passwordParameter("password")
                .and()
                    .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/").permitAll();
    }
}
