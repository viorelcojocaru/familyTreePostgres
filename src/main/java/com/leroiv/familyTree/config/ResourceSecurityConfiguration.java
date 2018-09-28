package com.leroiv.familyTree.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalAuthentication
public class ResourceSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        User user=new User();
      /*  user.setRoleId(Roles.ADMIN);*/
        http.authorizeRequests()
                .antMatchers("/person").authenticated()
                //.antMatchers("/add").hasAuthority(user.getRoleId()==Roles.ADMIN?"ADMIN":"USER")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
}
