package kr.geun.oss.base;

import kr.geun.oss.base.infra.config.mysql.LogDbConfiguration;
import kr.geun.oss.base.infra.config.mysql.MainDbConfiguration;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BaseTestModule
 *
 * @author akageun
 * @since 2019-10-10
 */
@RunWith(SpringRunner.class)
@ActiveProfiles({"local"})
@TestPropertySource("classpath:/config/application.yml")
@Import({
    MainDbConfiguration.class,
    LogDbConfiguration.class
})
public abstract class BaseTestModule {
}
