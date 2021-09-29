package com.sda.fish.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/frontpage","/login","/imagines/**","/register").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
 //       http.httpBasic();
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/frontpage")
                .failureForwardUrl("/login");

        http.logout().logoutUrl("/logout").logoutSuccessUrl("/frontpage").deleteCookies("JSESSIONID");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth, DataSource dataSource, PasswordEncoder passwordEncoder) throws Exception{


        auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource);
        System.out.println(passwordEncoder.encode("user"));
//                .inMemoryAuthentication()
//                .withUser("dumitras").password(passwordEncoder.encode("userpass")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder.encode("adminpass")).roles("ADMIN")
//        .and().passwordEncoder(passwordEncoder);

    }
}
