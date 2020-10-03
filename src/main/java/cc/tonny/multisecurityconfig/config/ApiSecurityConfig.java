package cc.tonny.multisecurityconfig.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/admin**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().httpBasic();
    }
}
