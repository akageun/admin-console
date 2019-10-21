package kr.geun.oss.base.infra.entity.main.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * UserEntity
 * - 유저
 *
 * @author akageun
 * @since 2019-09-30
 */
@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String passWd;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String useYn;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime lastLogin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime passWdChange;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, updatable = false)
    private String createUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String updateUserId;

    @Builder
    public UserEntity(
        String userId, String passWd, String useYn, String email,
        LocalDateTime lastLogin, LocalDateTime passWdChange, LocalDateTime createdAt, LocalDateTime updatedAt,
        String createUserId, String updateUserId
    ) {
        this.userId = userId;
        this.passWd = passWd;
        this.useYn = useYn;
        this.email = email;
        this.passWdChange = passWdChange;
        this.lastLogin = lastLogin;
        this.createdAt = createdAt;
        this.createUserId = createUserId;
        this.updatedAt = updatedAt;
        this.updateUserId = updateUserId;
    }
}
