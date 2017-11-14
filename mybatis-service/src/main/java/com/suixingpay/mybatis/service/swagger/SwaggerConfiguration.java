package com.suixingpay.mybatis.service.swagger;

/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: li_yang@suixingpay.com
 * @date: 2017/3/31 10:19
 * @copyright: ©2017 Suixingpay. All rights reserved. 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * EnableSwagger2配置
 *
 * @author: li_yang@suixingpay.com
 * @date: 2017/3/31 10:19
 * @version: V1.0
 * @review: li_yang@suixingpay.com/2017/3/31 10:19
 */
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = SwaggerConfiguration.PREFIX)
@Profile("dev")
public class SwaggerConfiguration {

    /**
     *
     */
    public static final String PREFIX = "swagger2";

    /**
     *
     */
    private String basePackage;

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String contactName;

    /**
     *
     */
    private String contactUrl;

    /**
     *
     */
    private String version;
    
    private String email;

    /**
     * api
     * 
     * @return
     */
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(info()).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any())
                .build();
    }

    /**
     * info
     * 
     * @return
     */
    private ApiInfo info() {

        return new ApiInfoBuilder().title(title).contact(new Contact(contactName, contactUrl, email))
                .version(version).build();
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
