package com.boris.hotel_application.security;

import com.boris.hotel_application.service.AdminService;
import com.boris.hotel_application.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AdminService adminService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v*/registration/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/hotels/admin/**").hasRole("ADMIN")
                .antMatchers("/hotels/user/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated().and()
                .formLogin().permitAll().and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(daoAuthenticationProvider());

        auth.authenticationProvider(admin());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);

        return provider;
    }

    @Bean
    public DaoAuthenticationProvider admin(){
        DaoAuthenticationProvider admin =
                new DaoAuthenticationProvider();
        admin.setPasswordEncoder(bCryptPasswordEncoder);
        admin.setUserDetailsService(adminService);

        return admin;
    }


}
