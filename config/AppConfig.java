package com.in28minutes.springboot.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

// load đầu tiên khi chạy chương trình và đánh dấu nó là 1 file cấu hình
@Configuration

// anotation tu động cấu hình jpa
@EnableJpaRepositories(
        entityManagerFactoryRef = "customersEntityManager",
        transactionManagerRef = "customersTransactionManager",
        basePackages = {"com.in28minutes.springboot.reponsitory"})
// nguồn thuộc tính để tạo environment
@PropertySource("classpath:application.properties")
public class AppConfig {

    //tiem môi trường application context
    @Autowired
    private Environment environment;

    // đinh nghia thuoc tính bằng hằng
    public static final String PACKAGE_CUSTOMER ="com.in28minutes.springboot.model";

    // config dataSource = kết nối đến csdl
    // đánh dấu bean
    @Bean("customersDataSource")
    @Primary
    public DataSource getDataSourceMysql() {
        // lấy các thuộc tính trong application.properties
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        dataSource.url(environment.getProperty("spring.datasource.url"));
        dataSource.username(environment.getProperty("spring.datasource.username"));
        dataSource.password(environment.getProperty("spring.datasource.password"));
        return dataSource.build();
    }

    // quản lí dữ liệu khách hàng
    @Bean(name = "customersEntityManager")
    public LocalContainerEntityManagerFactoryBean getCustomersEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("customersDataSource") DataSource customersDataSource){
        // config bean entity của data base tương đương với bảng, config jpa
        LocalContainerEntityManagerFactoryBean result = builder
                .dataSource(customersDataSource)
                .packages(PACKAGE_CUSTOMER)
                .persistenceUnit("customers")
                .properties(additionalJpaProperties())
                .build();
        return result;
    }

    // lưu key, value trong qpplication.properties vào map
    Map<String,String> additionalJpaProperties(){
        Map<String,String> map = new HashMap<>();

        map.put("spring.jpa.hibernate.ddl-auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        map.put("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));

        return map;
    }

    @Bean(name = "customersTransactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("customersEntityManager") EntityManagerFactory customersEntityManager){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(customersEntityManager);
        return transactionManager;
    }

}