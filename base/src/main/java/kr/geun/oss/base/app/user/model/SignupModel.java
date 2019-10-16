package kr.geun.oss.base.app.user.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SignupModel
 *
 * @author akageun
 * @since 2019-10-16
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupModel {

    private String email;
    private String passwd;

}
