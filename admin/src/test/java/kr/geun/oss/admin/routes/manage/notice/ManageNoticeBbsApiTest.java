package kr.geun.oss.admin.routes.manage.notice;

import kr.geun.oss.base.app.notice.service.NoticeBbsService;
import kr.geun.oss.base.infra.config.mysql.LogDbConfiguration;
import kr.geun.oss.base.infra.config.mysql.MainDbConfiguration;
import kr.geun.oss.base.infra.repo.main.notice.NoticeBbsRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@ActiveProfiles({"local"})
//@TestPropertySource("classpath:/config/application.yml")
@Import({
    MainDbConfiguration.class,
    LogDbConfiguration.class
})
@EnableAutoConfiguration(exclude =
    {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
    }
)
@SpringBootTest(classes = {
    ManageNoticeBbsApi.class,
    NoticeBbsService.class,
    NoticeBbsRepo.class
})
public class ManageNoticeBbsApiTest {

    @Autowired
    private ManageNoticeBbsApi manageNoticeBbsApi;


    @Test
    public void test() {
        manageNoticeBbsApi.manageNoticeList();
    }
}
