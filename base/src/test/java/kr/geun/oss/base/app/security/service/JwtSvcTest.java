package kr.geun.oss.base.app.security.service;

import kr.geun.oss.base.BaseTestModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@EnableAutoConfiguration(exclude =
    {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
    }
)
@SpringBootTest(classes = {
    JwtSvc.class,
})
public class JwtSvcTest extends BaseTestModule {

    @Autowired
    private JwtSvc jwtSvc;

    @Test
    public void generateToken() {
        //jwtSvc.generate(new PasswordAuthentication())
    }

}
