package kr.geun.oss.base.app.user.service;

import kr.geun.oss.base.infra.entity.main.user.UserEntity;
import kr.geun.oss.base.infra.repo.main.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * UserManageSvc
 *
 * @author akageun
 * @since 2019-10-06
 */
@Slf4j
@Service
public class UserManageSvc {

    @Autowired
    private UserRepository userRepository;

    /**
     * 단건조회
     *
     * @param userId
     * @return
     */
    public UserEntity find(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not Found Exception"));
    }

    /**
     * 유효성 검산
     *
     * @param userId
     * @param email
     */
    public void valid(String userId, String email) {
        UserEntity entity = userRepository.findById(userId).orElse(null);
        if (entity != null) {
            throw new RuntimeException("Already User Id");
        }

        //Email 관련 validation
    }

    @Transactional
    public void createUser(String userId, String passWd, String email) {
        LocalDateTime ldt = LocalDateTime.now();

        UserEntity entity = UserEntity.builder()
            .userId(userId)
            .passWd(passWd)
            .email(email)
            .useYn("Y")
            .passWdChange(ldt)
            .lastLogin(ldt)
            .createdAt(ldt)
            .createUserId(userId)
            .updatedAt(ldt)
            .updateUserId(userId)
            .build();

        userRepository.save(entity);
    }
}
