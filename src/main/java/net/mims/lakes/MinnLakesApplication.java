package net.mims.lakes;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.server.servlet.ConfigurableServletWebServerFactory;


import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@ComponentScan(basePackages = {"net.mims.lakes"})
@EntityScan("net.mims.lakes.entity")
@EnableJpaRepositories("net.mims.lakes.repositories")
public class MinnLakesApplication extends SpringBootServletInitializer{

 @Bean
  @ConfigurationProperties(prefix = "datasource")
  HikariDataSource dataSource() {
      
      HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.setDriverClassName("org.postgresql.Driver");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
      
      
    return new HikariDataSource(config);
  }

  @Bean(name = "entityManagerFactory")
  @Primary
  LocalContainerEntityManagerFactoryBean entityManager() {
    final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    localContainerEntityManagerFactoryBean.setDataSource((javax.sql.DataSource) dataSource());
    localContainerEntityManagerFactoryBean.setPackagesToScan("net.mims.lakes.repositories","net.mims.lakes.entity");
    localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
    return localContainerEntityManagerFactoryBean;
  }

  @Bean(name = "transactionManager")
  @Primary
  PlatformTransactionManager euTransactionManager() {
    final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManager().getObject());
    return jpaTransactionManager;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    properties.setProperty("hibernate.connection.release_mode", "auto");
    properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
    properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
    properties.setProperty("hibernate.connection.username", "postgres");
    properties.setProperty("hibernate.connection.password", "postgres");
    properties.setProperty("hibernate.connection.password", "postgres");

    
    return properties;
  }
  
     @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return factory -> factory.setRegisterDefaultServlet(true);
    }
    private static final Logger log = LoggerFactory.getLogger(MinnLakesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MinnLakesApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MinnLakesApplication.class);
        
        
    }
    
  
    
}
