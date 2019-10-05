package kr.geun.oss.base.infra.config.mysql;

import com.zaxxer.hikari.HikariDataSource;
import kr.geun.oss.base.infra.config.mysql.annotation.LogDb;
import kr.geun.oss.base.infra.entity.log.LogTargetEntityAnnotation;
import kr.geun.oss.base.infra.repo.log.LogTargetRepoAnnotation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * LogDbConfiguration
 *
 * @author akageun
 * @since 2019-09-30
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackageClasses = {LogTargetRepoAnnotation.class},
    transactionManagerRef = "logJpaTransactionManager",
    entityManagerFactoryRef = "logEntityManagerFactory"
)

@MapperScan(
    basePackages = "kr.geun.oss.base.infra.dao.log.**",
    annotationClass = LogDb.class,
    sqlSessionFactoryRef = "logSQLSession"
)
public class LogDbConfiguration {

    @Bean(name = "logDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.log")
    public DataSource logDataSource() throws SQLException {
        return new HikariDataSource();

    }

    @Bean(name = "logEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean logEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("logDataSource") DataSource dataSource
    ) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        return builder
            .dataSource(dataSource)
            .properties(properties)
            .packages(LogTargetEntityAnnotation.class)
            .persistenceUnit("log")
            .build();


    }

    @Bean(name = "logJpaTransactionManager")
    public PlatformTransactionManager logTransactionManager(
        @Qualifier("logEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);

    }


    /**
     * sqlSessionFactory 선언
     *
     * @return
     * @throws Exception
     */
//    @Bean(name = "logSQLSession")
//    public SqlSessionFactoryBean sqlSessionFactoryBean(
//        @Qualifier("logDataSource") DataSource dataSource
//    ) throws Exception {
//
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//
//        // mybatis mapper 위치 설정
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/log/**/*.xml"));
//        return sessionFactory;
//    }

    /**
     * 트랜젝션 선언
     *
     * @return
     */
//    @Bean(name = "subTransactionManager")
//    public DataSourceTransactionManager transactionManager(
//        @Qualifier("logDataSource") DataSource dataSource
//    ) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    /**
     * aop 설정
     *
     * @return
     */
//    @Bean(name = "subTransactionAdvice")
//    public TransactionInterceptor txAdvice(
//        @Qualifier("subTransactionManager") DataSourceTransactionManager transactionManager
//    ) {
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
//    @Bean(name = "subTransactionAdvisor")
//    public Advisor txAdviceAdvisor(
//        @Qualifier("subTransactionAdvice") TransactionInterceptor txAdvice
//    ) {
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression("execution(* kr.geun.oss.base..*Svc.*(..))");
//        return new DefaultPointcutAdvisor(pointcut, txAdvice);
//    }

}
