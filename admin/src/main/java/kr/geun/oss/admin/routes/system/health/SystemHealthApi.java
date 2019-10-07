package kr.geun.oss.admin.routes.system.health;

import kr.geun.oss.base.infra.mapper.log.system.LogHealthCheckMapper;
import kr.geun.oss.base.infra.mapper.main.system.MainHealthCheckMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MainHealthCheckMapper mainHealthCheckMapper;

    @Autowired
    private LogHealthCheckMapper logHealthCheckMapper;

    @GetMapping("/system/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/system/database")
    public String healthCheckDatabase() {
        String mainDb = mainHealthCheckMapper.selectNow();
        String logDb = logHealthCheckMapper.selectNow();

        return "OK";
    }
}
