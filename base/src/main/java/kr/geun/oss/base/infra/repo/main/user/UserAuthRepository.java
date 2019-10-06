package kr.geun.oss.base.infra.repo.main.user;


import kr.geun.oss.base.infra.entity.main.user.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * UserManageSvc
 * - 유저 - 권한 repo
 *
 * @author akageun
 * @since 2019-10-06
 */
public interface UserAuthRepository extends JpaRepository<UserAuthEntity, Long> {

    /**
     * 유저 아이디로 가져오기
     *
     * @param userId
     * @return
     */
    List<UserAuthEntity> findByUserId(String userId);
}
