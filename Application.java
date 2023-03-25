///usr/bin/env jbang "$0" "$@" ; exit $?

//JAVA 17+

//DEPS org.springframework.boot:spring-boot-dependencies:3.0.5@pom
//DEPS org.springframework.boot:spring-boot-starter-web
//DEPS org.springframework.boot:spring-boot-starter-security
//DEPS org.springframework.boot:spring-boot-starter-actuator
//DEPS org.springframework.security:spring-security-oauth2-jose
//DEPS org.springframework.security:spring-security-oauth2-resource-server

//FILES application.properties

package demo;

import org.springframework.boot.Banner;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableWebSecurity
@EnableMethodSecurity
public class Application {

    public static void main(String... args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .lazyInitialization(true)
                .sources(Application.class)
                .main(Application.class)
                .run(args);
    }

    @Bean
    public SecurityFilterChain healthFilterChain(HttpSecurity http) throws Exception {
        return http.securityMatcher(EndpointRequest.to(HealthEndpoint.class))
                .authorizeHttpRequests((requests) -> requests.anyRequest().permitAll())
                .build();
    }

    @Bean
    public SecurityFilterChain oauth2FilterChain(HttpSecurity http) throws Exception {
        return http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .authorizeHttpRequests().anyRequest().authenticated().and()
                .anonymous().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .build();
    }

    @RequestMapping("/")
    @PreAuthorize("hasAuthority('SCOPE_hello')")
    public String hello() {
        return "Hello Spring Boot!";
    }

}
