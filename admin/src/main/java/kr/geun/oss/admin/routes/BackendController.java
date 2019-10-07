package kr.geun.oss.admin.routes;

import kr.geun.oss.base.infra.mapper.log.system.LogHealthCheckMapper;
import kr.geun.oss.base.infra.mapper.main.system.MainHealthCheckMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class BackendController implements InitializingBean {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        return "Vue.js Test Text 2";
    }

    @Autowired
    private MainHealthCheckMapper mainHealthCheckMapper;

    @Autowired
    private LogHealthCheckMapper logHealthCheckMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("main :{}, log : {}", mainHealthCheckMapper.selectNow(), logHealthCheckMapper.selectNow());
    }
}
