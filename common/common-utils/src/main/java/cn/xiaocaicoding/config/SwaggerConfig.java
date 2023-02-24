package cn.xiaocaicoding.config;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: xiaocai
 * @since: 2023/02/23/21:43
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
//                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }


    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-谷粒学院API文档")
                .description("谷粒学院接口定义")
                .version("1.0")
                .contact(new Contact("java", "https://xiaocaicoding.cn", "mildcaq@163.com"))
                .build();
    }
}
