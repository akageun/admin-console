package kr.geun.oss.base.infra.entity.main.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 유저 - 권한
 *
 * @author akageun
 */
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user_auth")
public class UserAuthEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userAuthId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String authorityCd;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public UserAuthEntity(String userId, String authorityCd, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.authorityCd = authorityCd;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
