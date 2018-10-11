package com.leroiv.familyTree.config;

import com.leroiv.familyTree.constants.Roles;
import com.leroiv.familyTree.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@Configuration
//@EnableGlobalAuthentication
public class JdbcSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Bean
//    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
//        RowMapper<User> userRowMapper = (ResultSet rs, int i) ->
//                new User(
//                        rs.getString("USER_NAME"),
//                        rs.getString("PASSWORD"),
//                        /*rs.getBoolean("ENABLED"),
//                        rs.getBoolean("ENABLED"),
//                        rs.getBoolean("ENABLED"),
//                        rs.getBoolean("ENABLED"),*/
//                        AuthorityUtils.createAuthorityList(getRoles().stream().toArray(String[]::new)));
//
//        return username ->
//                jdbcTemplate.queryForObject("SELECT * from user where user_name = ?",
//                        userRowMapper, username);
//    }
//    List<String> getRoles(){
//            return roleRepository.findAll().stream().map(role -> role.getName()).collect(Collectors.toList());
//    }
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.userDetailsService);
//    }
}
