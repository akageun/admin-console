package kr.geun.oss.base.app.notice.service;

import kr.geun.oss.base.infra.config.mysql.LogDbConfiguration;
import kr.geun.oss.base.infra.config.mysql.MainDbConfiguration;
import kr.geun.oss.base.infra.entity.main.notice.NoticeBbsEntity;
import kr.geun.oss.base.infra.repo.main.notice.NoticeBbsRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@ActiveProfiles({"local"})
@SpringBootTest(classes = {
    NoticeBbsService.class,
    NoticeBbsRepo.class
})
@Import({
    MainDbConfiguration.class,
    LogDbConfiguration.class
})
public class NoticeBbsServiceTest {

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
