package kr.geun.oss.admin.routes.manage.user;

import kr.geun.oss.base.app.notice.service.NoticeBbsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/api/v1/manage/user/list")
    public String getManageUserList() {


        return "";
    }

    @GetMapping("/api/v1/manage/user/get")
    public String getManageUser() {
        return "";
    }
}
