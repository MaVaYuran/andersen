package by.mariayuran;

import by.mariayuran.hibernate.entity.Ticket;
import by.mariayuran.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
            @Value("${hibernate.show_sql}") String showSQL,
            @Value("true") String debug,
            @Value("${hibernate.dialect}") String dialect) {

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.show_sql", showSQL);
        hibernateProperties.put("debug", debug);
        hibernateProperties.put("hibernate.dialect)", dialect);
        return hibernateProperties;
    }

    @Bean
    public DataSource newDataSource(
            @Value("${db.driver}") String driver,
            @Value("${db.url}") String url,
            @Value("${db.username}") String username,
            @Value("${db.password}") String password
    ) {

        DataSource dataSource = new SingleConnectionDataSource(url,username, password, true);

        return dataSource;
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
