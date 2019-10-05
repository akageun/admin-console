package kr.geun.oss.base.infra.entity.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String passWd;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public UserEntity(String userId, String passWd, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.passWd = passWd;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
