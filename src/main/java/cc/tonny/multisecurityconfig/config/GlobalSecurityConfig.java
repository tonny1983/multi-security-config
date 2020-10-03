package cc.tonny.multisecurityconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class GlobalSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        var manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build());
        manager.createUser(
                User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());
        return manager;
    }

    @Autowired
    protected void configureGlobalAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceBean());
    }
}
