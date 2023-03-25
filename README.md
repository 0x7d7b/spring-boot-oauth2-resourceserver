Make sure `jbang` is installed. See: https://jbang.dev.

Then run:

    $ jbang Application.java
    
    [jbang] Resolving dependencies...
    [jbang]    org.springframework.boot:spring-boot-dependencies:3.0.5@pom
    [jbang]    org.springframework.boot:spring-boot-starter-web:3.0.5
    [jbang]    org.springframework.boot:spring-boot-starter-security:3.0.5
    [jbang]    org.springframework.security:spring-security-oauth2-jose:6.0.2
    [jbang]    org.springframework.security:spring-security-oauth2-resource-server:6.0.2
    [jbang] Dependencies resolved
    [jbang] Building jar...
    2023-03-25T18:12:34.454+01:00  INFO 83977 --- [           main] demo.Application                         : Starting Application using Java 17.0.6 with PID 83977 (/Users/hs/.jbang/cache/jars/Application.java.97710592cb9f7561b458bed88f40f8c6c8d5cb15b0b2e0f74d13c1e931675641/Application.jar started by hs in /Users/hs/Development/jbang-tests)
    2023-03-25T18:12:34.462+01:00  INFO 83977 --- [           main] demo.Application                         : No active profile set, falling back to 1 default profile: "default"
    2023-03-25T18:12:36.112+01:00  INFO 83977 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    2023-03-25T18:12:36.129+01:00  INFO 83977 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2023-03-25T18:12:36.130+01:00  INFO 83977 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.7]
    2023-03-25T18:12:36.278+01:00  INFO 83977 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2023-03-25T18:12:36.281+01:00  INFO 83977 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1645 ms
    2023-03-25T18:12:36.528+01:00  INFO 83977 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    2023-03-25T18:12:36.599+01:00  INFO 83977 --- [           main] demo.Application                         : Started Application in 2.7 seconds (process running for 3.27)
