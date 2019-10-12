package kr.geun.oss.base.app.security.service;

import kr.geun.oss.base.app.security.model.AdminUser;
import kr.geun.oss.base.infra.entity.main.user.UserAuthEntity;
import kr.geun.oss.base.infra.entity.main.user.UserEntity;
import kr.geun.oss.base.infra.repo.main.user.UserAuthRepository;
import kr.geun.oss.base.infra.repo.main.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * AcUserDetailsService
 *
 * @author akageun
 * @since 2019-10-12
 */
@Slf4j
@Service
public class AcUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthRepository userAuthRepository;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserId(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("NOT Found User");
        }

        List<UserAuthEntity> authList = userAuthRepository.findByUserId(username);
        if (authList.isEmpty()) {
            throw new UsernameNotFoundException("계정 내 권한이 없습니다.");
        }

        return new AdminUser(
            userEntity.getUserId(),
            userEntity.getPassWd(),
            0,
            userEntity.getUseYn(),
            new Date(),
            new Date(),
            mapToGrantedAuthorities(authList.stream().map(UserAuthEntity::getAuthorityCd).collect(Collectors.toList()))
        );
    }

    private Set<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }
}
