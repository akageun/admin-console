package kr.geun.oss.admin.config.security.model;

import kr.geun.oss.base.common.constants.AcConst;
import kr.geun.oss.base.common.model.BaseModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * AdminUser
 *
 * @author akageun
 * @since 2019-10-11
 */
@Getter
@NoArgsConstructor
public class AdminUser extends BaseModel implements UserDetails {

    private static final long serialVersionUID = -2821226048682020940L;

    private String userId;
    private String passWd;

    private int loginFailCount;
    private String useYn;

    private LocalDateTime passWdChange;
    private LocalDateTime lastLogin;

    private Set<GrantedAuthority> authorities;

    @Builder
    public AdminUser(
        String userId,
        String passWd,
        int loginFailCount,
        String useYn,
        LocalDateTime passWdChange,
        LocalDateTime lastLogin,
        Set<GrantedAuthority> authorities
    ) {
        this.userId = userId;
        this.passWd = passWd;
        this.loginFailCount = loginFailCount;
        this.useYn = useYn;
        this.passWdChange = passWdChange;
        this.lastLogin = lastLogin;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }

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
        return this.getAuthorities();
    }

    /**
     * 계정 만료여부
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        LocalDateTime ldt = LocalDateTime.now().minus(Duration.ofDays(AcConst.LOGIN_EXPIRED_PERIOD));
        if (ldt.isBefore(this.getLastLogin())) {
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
        LocalDateTime ldt = LocalDateTime.now().minus(Duration.ofDays(AcConst.LOGIN_EXPIRED_PERIOD));
        if (ldt.isBefore(this.getPassWdChange())) {
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

    private SortedSet<GrantedAuthority> sortAuthorities(
        Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per
        // UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(
            new AdminUser.AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority,
                "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to
            // the set.
            // If the authority is null, it is a custom authority and should precede
            // others.
            if (g2.getAuthority() == null) {
                return -1;
            }

            if (g1.getAuthority() == null) {
                return 1;
            }

            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
}
