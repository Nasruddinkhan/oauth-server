package com.mypractice.oauth.server.oauthserver.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfig {
    @Bean
    public MessageSource messageSource() {
        final var source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }


    @Bean
    @Primary
    public LocalValidatorFactoryBean getValidator() {
        final var bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
