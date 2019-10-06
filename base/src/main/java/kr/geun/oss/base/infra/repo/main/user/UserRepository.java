package kr.geun.oss.base.infra.repo.main.user;


import kr.geun.oss.base.infra.entity.main.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * UserManageSvc
 * - 유저 repo
 *
 * @author akageun
 * @since 2019-10-06
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUserId(String userId);
}
