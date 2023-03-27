package by.mysite.config;

import by.mysite.model.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.servlet.ViewResolver;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan("by.mysite.controllers")
public class AppConfig {
    @Bean
    public ViewResolver viewResolver() {
        System.out.println("ViewResolver");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public Configuration configuration(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }

    @Bean
    public SessionFactory sessionFactory(Configuration configuration){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}
