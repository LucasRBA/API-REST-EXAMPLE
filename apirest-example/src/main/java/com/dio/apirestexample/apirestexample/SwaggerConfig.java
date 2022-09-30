//package com.dio.apirestexample.apirestexample;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    private Contact contact() {
//        return new Contact(
//                "Lucas",
//                "https://github.com/LucasRBA",
//                "lucas.rafaelba.kc@gamil.com");
//    }
//
//    private ApiInfoBuilder apiInfo() {
//
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//        apiInfoBuilder.title("Rest Login API");
//        apiInfoBuilder.description("Example of REST Login API");
//        apiInfoBuilder.version("0.8");
//        apiInfoBuilder.license("Everyone that forks it !!!!");
//        apiInfoBuilder.contact(this.contact());
//
//        return apiInfoBuilder;
//    }
//
//    @Bean
//    public Docket apiDetails() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//        docket
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.dio.apirestexample.apirestexample.controllers"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(this.apiInfo().build() )
//                .consumes(new HashSet<String>(Arrays.asList("application/json")))
//                .produces(new HashSet<String>(Arrays.asList("application/json")));
//        return docket;
//    }
//}
