package com.loan.api.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by shuttle on 5/25/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket newsApi() {
        //return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(true);
        docket.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage( "com.loan.api" ) )
                .paths(showControllers())
                .build();
        return docket;
    }

    /**
     * 显示哪些页面
     *
     * @return
     */
    private Predicate<String> showControllers() {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                //                return input.contains("/v1/");
                return true;//不拦截

            }
        };
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("api接口查看平台")
                .description("在这里你可以浏览项目所有接口，并提供相关测试工具")
                //.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("shuttle")
                //.license("China Red Star Licence Version 1.0")
                //.licenseUrl("#")
                .version("1.0")
                .build();
    }
}
