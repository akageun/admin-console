package kr.geun.oss.base.app.notice.service;

import kr.geun.oss.base.infra.repo.main.notice.NoticeBbsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
