package es.egven.tjenterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * TJ.enterprise
 * Petstore - web shop
 * @author Egven
 * @version 0.0.1
 */
@SpringBootApplication
@EntityScan(basePackages = "es.egven.tjenterprise.model")
@ComponentScan(basePackages = "es.egven.tjenterprise.controllers")
@EnableJpaRepositories(basePackages = "es.egven.tjenterprise.model")
public class TjenterpriseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TjenterpriseApplication.class, args);
    }

    /**
     * @return Catches message source to be able to handle messages in Resource Bundle
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * @return Gets local validator factory bean to reveal validation error messages
     */
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
