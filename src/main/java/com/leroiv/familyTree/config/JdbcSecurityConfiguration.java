package com.leroiv.familyTree.config;

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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
@EnableGlobalAuthentication
public class JdbcSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
        RowMapper<User> userRowMapper = (ResultSet rs, int i) -> getUserFromDB(rs);

        return username -> jdbcTemplate.queryForObject("SELECT u.password, u.login, u.id FROM public.user u WHERE u.login = ?", userRowMapper, username);
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);

    }

    @Autowired
    private RoleRepository roleRepository;

    private User getUserFromDB(ResultSet rs) throws SQLException {

        List<String> roles = new ArrayList<>();
        roleRepository.findAll().forEach(role -> roles.add(role.getName()));
        User user = new User(
                rs.getString("login"),
                rs.getString("password"),
                rs.getBoolean("ENABLED"),
                rs.getBoolean("ENABLED"),
                rs.getBoolean("ENABLED"),
                rs.getBoolean("ENABLED"),
                AuthorityUtils.createAuthorityList("ADMIN"));//(String[]) roles.toArray())

        return user;
    }


}
