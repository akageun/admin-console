package kr.geun.oss.base.infra.config.mysql;

import com.zaxxer.hikari.HikariDataSource;
import kr.geun.oss.base.infra.config.mysql.annotation.MainDb;
import kr.geun.oss.base.infra.entity.main.MainTargetEntityAnnotation;
import kr.geun.oss.base.infra.repo.main.MainTargetRepoAnnotation;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author akageun
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackageClasses = {MainTargetRepoAnnotation.class},
    transactionManagerRef = "mainJpaTransactionManager",
    entityManagerFactoryRef = "mainEntityManagerFactory"
)
@MapperScan(
    basePackages = "kr.geun.oss.base.infra.dao.main.**",
    annotationClass = MainDb.class,
    sqlSessionFactoryRef = "mainSQLSession"
)
public class MainDbConfiguration {

    @Primary
    @Bean(name = "mainDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.main")
    public DataSource mainDataSource() throws SQLException {
        return new HikariDataSource();

    }

    @Primary
    @Bean(name = "mainEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("mainDataSource") DataSource dataSource
    ) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");

        return builder
            .dataSource(dataSource)
            .properties(properties)
            .packages(MainTargetEntityAnnotation.class)
            .persistenceUnit("mapper/main")
            .build();

    }

    @Primary
    @Bean(name = "mainJpaTransactionManager")
    public PlatformTransactionManager mainTransactionManager(
        @Qualifier("mainEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);

    }

    /**
     * sqlSessionFactory 선언
     *
     * @return
     * @throws Exception
     */
//    @Primary
//    @Bean(name = "mainSQLSession")
//    public SqlSessionFactoryBean sqlSessionFactoryBean(
//        @Qualifier("mainDataSource") DataSource dataSource
//    ) throws Exception {
//
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//
//        // mybatis mapper 위치 설정
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/main/**/*.xml"));
//        return sessionFactory;
//    }

    /**
     * 트랜젝션 선언
     *
     * @return
     */
//    @Bean(name = "mainTransactionManager")
//    public DataSourceTransactionManager transactionManager(
//        @Qualifier("mainDataSource") DataSource dataSource
//    ) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    /**
     * aop 설정
     *
     * @return
     */
//    @Bean(name = "mainTransactionAdvice")
//    public TransactionInterceptor txAdvice(
//        @Qualifier("mainTransactionManager") DataSourceTransactionManager transactionManager
//    ) {
//
//        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
//        transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
//        //transactionAttribute.setTimeout(DBConstants.TX_METHOD_TIMEOUT);
//
//        NameMatchTransactionAttributeSource nameMatch = new NameMatchTransactionAttributeSource();
//        nameMatch.addTransactionalMethod("add*", transactionAttribute);
//        nameMatch.addTransactionalMethod("modify*", transactionAttribute);
//        nameMatch.addTransactionalMethod("delete*", transactionAttribute);
//
//        return new TransactionInterceptor(transactionManager, nameMatch);
//    }

    /**
     * aop 대상 설정
     *
     * @return
     */
//    @Bean(name = "mainTransactionAdvisor")
//    public Advisor txAdviceAdvisor(
//        @Qualifier("mainTransactionAdvice") TransactionInterceptor txAdvice
//    ) {
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression("execution(* kr.geun.oss.base..*Svc.*(..))");
//        return new DefaultPointcutAdvisor(pointcut, txAdvice);
//    }
}
