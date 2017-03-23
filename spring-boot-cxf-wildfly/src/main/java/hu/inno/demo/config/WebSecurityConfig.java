package hu.inno.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin()
             .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/soap/**").permitAll()
                .anyRequest().permitAll()
             .and()
                .rememberMe()
                .key("myAppKey")
                .rememberMeParameter("remember-me")
                .rememberMeCookieName("remember-me-cookie")
                .tokenValiditySeconds(86400);
    }
}
