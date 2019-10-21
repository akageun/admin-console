package kr.geun.oss.base.infra.entity.main.notice;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.geun.oss.base.common.model.BaseModel;
import kr.geun.oss.base.common.utils.DateUtils;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * NoticeBbsEntity
 *
 * @author akageun
 * @since 2019-10-07
 */
@Entity
@Table(name = "notice_bbs")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NoticeBbsEntity extends BaseModel {

    @Builder
    public NoticeBbsEntity(
        String statusCd, String title, String content,
        String createdUserId, String updatedUserId,
        LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.statusCd = statusCd;
        this.title = title;
        this.content = content;
        this.createdUserId = createdUserId;
        this.updatedUserId = updatedUserId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noticeId;

    @Column(nullable = false)
    private String statusCd;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false, updatable = false)
    private String createdUserId;

    @Column(nullable = false)
    private String updatedUserId;

    /**
     * 생성일시
     */
    @JsonFormat(pattern = DateUtils.YMDHMS_FOR_READONLY)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonFormat(pattern = DateUtils.YMDHMS_FOR_READONLY)
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


}
