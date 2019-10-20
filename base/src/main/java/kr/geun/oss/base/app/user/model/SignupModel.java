package kr.geun.oss.base.app.user.model;

import kr.geun.oss.base.common.model.BaseModel;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * SignupModel
 *
 * @author akageun
 * @since 2019-10-16
 */
@Slf4j
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupModel extends BaseModel {

    private String userId;
    private String passWd;
    private String confirmPassWd;
    private String email;

    @Builder
    public SignupModel(
        @NotBlank String userId,
        @NotBlank String passWd,
        @NotBlank String confirmPassWd,
        @Email String email) {
        this.userId = userId;
        this.passWd = passWd;
        this.confirmPassWd = confirmPassWd;
        this.email = email;
    }
}
