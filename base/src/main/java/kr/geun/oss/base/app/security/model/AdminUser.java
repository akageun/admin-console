package kr.geun.oss.base.app.security.model;

import kr.geun.oss.base.common.constants.AcConst;
import kr.geun.oss.base.common.utils.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * AdminUser
 *
 * @author akageun
 * @since 2019-10-11
 */
@Getter
@NoArgsConstructor
public class AdminUser implements UserDetails {

    private static final long serialVersionUID = -2821226048682020940L;

    private String userId;
    private String passWd;

    private int loginFailCount;
    private String useYn;

    private Date passWdChangeDate;
    private Date lastLoginDate;

    @Override
    public String getUsername() {
        return this.getUserId();
    }

    @Override
    public String getPassword() {
        return this.getPassWd();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 계정 만료여부
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        Date date = DateUtils.minusDays(new Date(), AcConst.LOGIN_EXPIRED_PERIOD);
        if (date.before(this.getPassWdChangeDate())) {
            return false;
        }

        return true;
    }

    /**
     * 계정 잠금여부
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        if (this.getLoginFailCount() >= AcConst.MAX_LOGIN_FAIL_COUNT) {
            return false;
        }

        return true;
    }

    /**
     * 비밀번호 만료여부
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        Date date = DateUtils.minusDays(new Date(), AcConst.PASSWD_CHANGE_PERIOD);
        if (date.before(this.getPassWdChangeDate())) {
            return false;
        }

        return true;
    }

    /**
     * 사용여부
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        if ("N".equals(this.getUseYn())) {
            return false;
        }

        return true;
    }
}
