package net.mims.lakes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"net.mims.minnlakes"})
//@EntityScan("net.mims.minnlakes.domain")
//@EnableJpaRepositories("net.mims.minnlakes.repositories")
public class MinnLakesApplication extends SpringBootServletInitializer{



    private static final Logger log = LoggerFactory.getLogger(MinnLakesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MinnLakesApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MinnLakesApplication.class);
    }
}
