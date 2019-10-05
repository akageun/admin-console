package kr.geun.oss.admin.config;

import kr.geun.oss.base.BasePackage;
import kr.geun.oss.base.infra.config.mysql.LogDbConfiguration;
import kr.geun.oss.base.infra.config.mysql.MainDbConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author akageun
 */
@Configuration
@ComponentScan(basePackageClasses = {BasePackage.class})
@Import({
        MainDbConfiguration.class,
        LogDbConfiguration.class
})
public class AdminConfiguration {
}
