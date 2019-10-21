package kr.geun.oss.admin.routes.user;

import kr.geun.oss.base.app.user.model.SignupModel;
import kr.geun.oss.base.app.user.service.UserManageSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private UserManageSvc userManageSvc;

    @PostMapping("/api/signup/v1/form")
    public String signup(
        @RequestBody @Valid SignupModel param,
        BindingResult result
    ) {
        if (result.hasErrors()) {

        }

        userManageSvc.valid(param.getUserId(), param.getEmail());
        userManageSvc.createUser(param.getUserId(), param.getPassWd(), param.getEmail());

        return "OK";
    }
}
