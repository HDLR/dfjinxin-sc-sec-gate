package com.dfjinxin.admin.config;

import com.dfjinxin.auth.client.interceptor.UserAuthRestInterceptor;
import com.dfjinxin.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.Collections;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
//    @Bean
//    GlobalExceptionHandler getGlobalExceptionHandler() {
//        return new GlobalExceptionHandler();
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//            .allowedOrigins("*")
//            .allowCredentials(true)
//            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//            .maxAge(3600);
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //  配置⽤用户认证拦截器器
        registry.addInterceptor(getUserAuthRestInterceptor()).
                addPathPatterns(getIncludePathPatterns());
    }

    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

    /**
     * 需要用户和服务认证判断的路径
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/sys/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //加了ApiOperation注解的类，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                //包下的类，才生成接口文档
//                //.apis(RequestHandlerSelectors.basePackage("io.dfjinxin.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(security());
//    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("dfjinxin")
//                .description("dfjinxin-fast文档")
//                .termsOfServiceUrl("http://www.seaboxdata.com")
//                .version("3.0.0")
//                .build();
//    }

//    private List<ApiKey> security() {
//        return newArrayList(
//                new ApiKey("token", "token", "header")
//        );
//    }

}
