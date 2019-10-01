package kr.geun.oss.admin.routes.system.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HealthApi
 *
 * @author akageun
 * @since 2019-09-30
 */
@Slf4j
@RestController
public class SystemHealthApi {

    @GetMapping("/system/health")
    public String healthCheck() {
        return "OK";
    }
}
