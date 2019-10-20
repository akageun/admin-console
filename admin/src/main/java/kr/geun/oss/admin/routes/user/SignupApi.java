package kr.geun.oss.admin.routes.user;

import kr.geun.oss.base.app.user.model.SignupModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        @Valid SignupModel param,
        BindingResult result
    ) {
        log.info("param :{}", param);
        log.info("result : {}", result);

        return "OK";
    }
}
