package gainmaster.service.oauth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(value = 2)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/oauth/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/**").permitAll();
        http.httpBasic().realmName("oauth").and().csrf().disable();
    }
}
