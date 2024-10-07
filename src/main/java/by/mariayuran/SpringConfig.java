package by.mariayuran;

import by.mariayuran.hibernate.entity.Ticket;
import by.mariayuran.hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("by.mariayuran")
@PropertySource(value = "classpath:application.properties")
@EnableTransactionManagement
public class SpringConfig {
    @Bean
    public Properties hibernateProperties(
            @Value("${hibernate.dialect}") String dialect,
            @Value("${hibernate.show_sql}") String showSQL,
            @Value("${hibernate.hbm2ddl.auto}") String ddlAuto
    ) {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSQL);
        properties.put("hibernate.hbm2ddl.auto", ddlAuto);
        return properties;
    }

    @Bean
    public DataSource newDataSource(
            @Value("${db.driver}") String driver,
            @Value("${db.url}") String url,
            @Value("${db.username}") String username,
            @Value("${db.password}") String password
    ) {
        return new SingleConnectionDataSource(url, username, password, true);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource,
                                                  @Qualifier("hibernateProperties") Properties hibernateProperties) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setHibernateProperties(hibernateProperties);
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setAnnotatedClasses(
                User.class,
                Ticket.class
        );
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
