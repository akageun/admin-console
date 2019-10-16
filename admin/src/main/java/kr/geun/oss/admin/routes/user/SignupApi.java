package kr.geun.oss.admin.routes.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SignupApi
 *
 * @author akageun
 * @since 2019-10-16
 */
@Slf4j
@RestController
public class SignupApi {

    @PostMapping("/api/signup/v1")
    public String signup(

    ) {

        return "OK";
    }
}
