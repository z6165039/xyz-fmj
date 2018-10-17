package com.jis.platform.fmj.config.swagger;
///**    
// * <p>Copyright (c) Shanghai TY Technology Co., Ltd. All Rights Reserved.</p>
// *
// * @FileName: 	FileWebSwagger2.java    
// * @Description:FileWebSwagger2  
// * @author: 	member
// * @Creat: 		2017年6月8日  
// *
// * Modification History:
// * Data			Author		Version		   Description
// * -------------------------------------------------------------
// * 2017年6月8日		member
// */
//package so.sao.member.configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.web.context.request.async.DeferredResult;
//
//import so.sao.sso.bind.CurrentUser;
//import so.sao.top.core.util.spring.ExtendProfiles;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Parameter;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @ClassName: SwaggerUIConfiguration
// */
//@Configuration
//@EnableSwagger2
//@Profile({ ExtendProfiles.DEFAULT, ExtendProfiles.DEVELOPMENT, ExtendProfiles.FRONT, ExtendProfiles.UNIT_TEST,
//        ExtendProfiles.STABLE })
//public class SwaggerUIConfiguration {
//
//    @Bean
//    public Docket portalDocumentation() {
//        return new Docket(DocumentationType.SWAGGER_2).genericModelSubstitutes(DeferredResult.class).groupName("portal")
//                .globalOperationParameters(getGlobalOperationParameters()).select()
//                .apis(RequestHandlerSelectors.basePackage("so.sao.member.controller.portal")).paths(PathSelectors.any()).build()
//                .ignoredParameterTypes(CurrentUser.class).apiInfo(portalInfo());
//    }
//
//    private ApiInfo portalInfo() {
//        return new ApiInfoBuilder().title("Member-Service Portal Reference Documentation")
//                .description("Use this documentation as a reference how to interact with member-service portal").version("1.0.0")
//                .build();
//    }
//
//    private List<Parameter> getGlobalOperationParameters() {
//        List<Parameter> list = new ArrayList<>();
//        Parameter auth = new ParameterBuilder().name("Authorization").description("Authorization")
//                .modelRef(new ModelRef("string")).parameterType("header").defaultValue("Bearer ").required(true).build();
//        list.add(auth);
//        return list;
//    }
//
//    @Bean
//    public Docket apiDocumentation() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("api").select()
//                .apis(RequestHandlerSelectors.basePackage("so.sao.member.controller.api")).paths(PathSelectors.any()).build()
//                .pathMapping("/").apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Member-Service Api Reference Documentation")
//                .description("Use this documentation as a reference how to interact with member-service API").version("1.0.0")
//                .build();
//    }
//
//    @Bean
//    public Docket templateDocumentation() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("template").select()
//                .apis(RequestHandlerSelectors.basePackage("so.sao.member.controller.template")).paths(PathSelectors.any()).build()
//                .pathMapping("/").apiInfo(templateInfo());
//    }
//
//    private ApiInfo templateInfo() {
//        return new ApiInfoBuilder().title("Member-Service Template Reference Documentation")
//                .description("Use this documentation as a reference how to interact with member-service TEMPLATE")
//                .version("1.0.0").build();
//    }
//
//    @Bean
//    public Docket wechatDocumentation() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("wechat").select()
//                .apis(RequestHandlerSelectors.basePackage("so.sao.member.controller.wechat")).paths(PathSelectors.any()).build()
//                .pathMapping("/").apiInfo(wechatInfo());
//    }
//
//    private ApiInfo wechatInfo() {
//        return new ApiInfoBuilder().title("Member-Service Wechat Reference Documentation")
//                .description("Use this documentation as a reference how to interact with member-service WECHAT").version("1.0.0")
//                .build();
//    }
//}
