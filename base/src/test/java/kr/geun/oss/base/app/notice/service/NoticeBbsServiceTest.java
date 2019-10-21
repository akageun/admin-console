package kr.geun.oss.base.app.notice.service;

import kr.geun.oss.base.BaseTestModule;
import kr.geun.oss.base.infra.entity.main.notice.NoticeBbsEntity;
import kr.geun.oss.base.infra.repo.main.notice.NoticeBbsRepo;
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
    NoticeBbsService.class,
    NoticeBbsRepo.class
})
public class NoticeBbsServiceTest extends BaseTestModule {

    @Autowired
    private NoticeBbsService noticeBbsService;


    @Test
    public void saveTest() {
        noticeBbsService.save();

        for (NoticeBbsEntity noticeBbsEntity : noticeBbsService.findAll()) {
            log.info("entity : {}", noticeBbsEntity);
        }
    }
}
