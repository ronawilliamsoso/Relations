package com.example.relations.config;

import com.example.relations.enums.HttpReturn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 08.03.20
 **/

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Learn JAP API").description("Restful").build();
    }

    @Bean
    public static Docket api() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        for ( HttpReturn httpReturn : HttpReturn.values() ) {
            responseMessageList.add(new ResponseMessageBuilder().code(httpReturn.getCode())
                    .message(httpReturn.getMessage()).responseModel(new ModelRef("string")).build());
        }
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList).select()
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }
}
