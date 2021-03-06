package com.sao.learning.hadoop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by saopr on 4/14/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    KerberosAuth kerberosAuth;

    @Autowired
    Configuration configuration;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            logger.info("Hello World");
            kerberosAuth.authenticate();
        };
    }

    @Bean
    public KerberosAuth kerberosAuth(ApplicationContext applicationContext) {
        return new KerberosAuth();
    }

    @Bean
    public Configuration configuration(ApplicationContext applicationContext) {
        return new Configuration();
    }
}
