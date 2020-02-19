package meyti.dogcheck.Config;

import com.google.common.base.Predicates;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwagerConfig {
    @Configuration
    @EnableSwagger2
    public static class SwaggerConfig {
        @Bean
        public Docket api() {
            List<SecurityScheme> schemeList = new ArrayList<>();
            schemeList.add(new ApiKey(HttpHeaders.AUTHORIZATION, "JWT", "header"));
            return new Docket(DocumentationType.SWAGGER_2)
                    .produces(Collections.singleton("application/json"))
                    .consumes(Collections.singleton("application/json"))
                    .ignoredParameterTypes(Authentication.class)
                    .securitySchemes(schemeList)
                    .useDefaultResponseMessages(false)
                    .select()
                    .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                    .paths(PathSelectors.any())
                    .build();
        }
    }
}
