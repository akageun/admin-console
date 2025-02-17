package kr.geun.oss.admin.routes.manage.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ManageUserApi
 *
 * @author akageun
 * @since 2019-09-30
 */
@Slf4j
@RestController
public class ManageUserApi {

    @GetMapping("/api/manage/v1/user/list")
    public String getManageUserList() {
        return "OK";
    }

    @GetMapping("/api/manage/v1/user/get")
    public String getManageUser() {
        return "OK";
    }
}
