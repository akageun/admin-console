package kr.geun.oss.base.app.user.error;

import kr.geun.oss.base.common.error.IErrorType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * UserErrorType
 *
 * @author akageun
 * @since 2019-10-21
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserErrorType implements IErrorType {
    NOT_FOUND_USER_ID("0000", "error.msg.notfound.userid"),
    ALREADY_USER_ID("0001", "error.msg.already.userid"),
    ;

    private String code;
    private String msgCode;

    UserErrorType(String code, String msgCode) {
        this.code = code;
        this.msgCode = msgCode;
    }

    @Override
    public String code() {
        return getCode();
    }

    @Override
    public String msgCode() {
        return getMsgCode();
    }

}
