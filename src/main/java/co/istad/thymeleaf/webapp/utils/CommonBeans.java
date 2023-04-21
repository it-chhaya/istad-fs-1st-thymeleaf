package co.istad.thymeleaf.webapp.utils;

import com.github.javafaker.Faker;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeans {
    @Bean
    public Faker faker() {
        return new Faker();
    }
}
