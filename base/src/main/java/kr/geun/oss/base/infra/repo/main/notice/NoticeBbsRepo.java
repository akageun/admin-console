package kr.geun.oss.base.infra.repo.main.notice;

import kr.geun.oss.base.infra.entity.main.notice.NoticeBbsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * NoticeBbsRepo
 *
 * @author akageun
 * @since 2019-10-07
 */
public interface NoticeBbsRepo extends JpaRepository<NoticeBbsEntity, Long> {
}
