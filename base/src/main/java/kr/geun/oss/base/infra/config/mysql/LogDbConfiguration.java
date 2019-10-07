package kr.geun.oss.base.infra.config.mysql;

import com.google.common.collect.ImmutableMap;
import com.zaxxer.hikari.HikariDataSource;
import kr.geun.oss.base.infra.config.mysql.annotation.LogDb;
import kr.geun.oss.base.infra.entity.log.LogTargetEntityAnnotation;
import kr.geun.oss.base.infra.repo.log.LogTargetRepoAnnotation;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
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
@EntityScan(basePackageClasses = {LogTargetEntityAnnotation.class})
@MapperScan(
    basePackages = "kr.geun.oss.base.infra.mapper.log.**",
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
    public EntityManagerFactory entityManagerFactory1(
        @Qualifier("logDataSource") DataSource dataSource
    ) {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaPropertyMap(ImmutableMap.of(
            "hibernate.hbm2ddl.auto", "update",
            "hibernate.dialect", "org.hibernate.dialect.H2Dialect",
            "hibernate.show_sql", "true"
        ));

        factory.setPackagesToScan("kr.geun.oss.base.infra.entity.long");
        factory.setPersistenceUnitName("log");
        factory.afterPropertiesSet();

        return factory.getObject();
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
    @Bean(name = "logSQLSession")
    public SqlSessionFactoryBean sqlSessionFactoryBean(
        @Qualifier("logDataSource") DataSource dataSource
    ) throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        // mybatis mapper 위치 설정
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/log/**/*.xml"));
        return sessionFactory;
    }

    /**
     * 트랜젝션 선언
     *
     * @return
     */
    @Bean(name = "subTransactionManager")
    public DataSourceTransactionManager transactionManager(
        @Qualifier("logDataSource") DataSource dataSource
    ) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * aop 설정
     *
     * @return
     */
    @Bean(name = "subTransactionAdvice")
    public TransactionInterceptor txAdvice(
        @Qualifier("subTransactionManager") DataSourceTransactionManager transactionManager
    ) {
        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
        transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        //transactionAttribute.setTimeout(DBConstants.TX_METHOD_TIMEOUT);

        NameMatchTransactionAttributeSource nameMatch = new NameMatchTransactionAttributeSource();
        nameMatch.addTransactionalMethod("add*", transactionAttribute);
        nameMatch.addTransactionalMethod("modify*", transactionAttribute);
        nameMatch.addTransactionalMethod("delete*", transactionAttribute);

        return new TransactionInterceptor(transactionManager, nameMatch);
    }

    /**
     * aop 대상 설정
     *
     * @return
     */
    @Bean(name = "subTransactionAdvisor")
    public Advisor txAdviceAdvisor(
        @Qualifier("subTransactionAdvice") TransactionInterceptor txAdvice
    ) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* kr.geun.oss.base..*Svc.*(..))");
        return new DefaultPointcutAdvisor(pointcut, txAdvice);
    }

}
