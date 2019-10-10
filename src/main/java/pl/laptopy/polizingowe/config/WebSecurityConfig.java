package pl.laptopy.polizingowe.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import pl.laptopy.polizingowe.entity.Roles;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PropertiesConfig propertiesConfig;

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/h2-console/**").disable()
                .headers().frameOptions().disable()
                .and().authorizeRequests().antMatchers("/api/**").permitAll()
                .and().authorizeRequests().antMatchers("/admin/**").permitAll()
                .and().authorizeRequests().antMatchers("/", "/index").permitAll()
                .and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username(propertiesConfig.getSecurityUsername())
                        .password(propertiesConfig.getSecurityPassword())
                        .roles(Roles.ADMIN.name())
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
