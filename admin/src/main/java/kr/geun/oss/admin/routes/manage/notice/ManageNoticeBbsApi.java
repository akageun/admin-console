package kr.geun.oss.admin.routes.manage.notice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ManageNoticeBbsApi
 *
 * @author akageun
 * @since 2019-10-07
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/manage")
public class ManageNoticeBbsApi {

    @GetMapping("/notice/list")
    public String manageNoticeList() {
        return "";
    }
}
