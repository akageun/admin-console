package kr.geun.oss.base.app.notice.service;

import kr.geun.oss.base.infra.entity.main.notice.NoticeBbsEntity;
import kr.geun.oss.base.infra.repo.main.notice.NoticeBbsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NoticeBbsService
 *
 * @author akageun
 * @since 2019-09-30
 */
@Slf4j
@Service
public class NoticeBbsService {

    @Autowired
    private NoticeBbsRepo noticeBbsRepo;

    public List<NoticeBbsEntity> findAll() {
        return noticeBbsRepo.findAll();
    }

    public void save() {
        NoticeBbsEntity entity = NoticeBbsEntity.builder()
            .title("제목")
            .content("내용")
            .statusCd("NORMAL")
            .build();

        log.info("entity : {}", entity);
        //noticeBbsRepo.save(entity);
    }

}
