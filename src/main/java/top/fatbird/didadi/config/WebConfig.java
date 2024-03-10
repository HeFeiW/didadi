//package top.fatbird.didadi.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(userRoleAuthorizationInterceptor())
////                .addPathPatterns("/**")
//                .excludePathPatterns("/imserver/**","/index","/chat/**","/detail/**");
//    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
////        tobefilt
//    }
//    @Bean
//    public UserRoleAuthorizationInterceptor  userRoleAuthorizationInterceptor(){return  new UserRoleAuthorizationInterceptor();}
////    ?
//}
