package kr.geun.oss.admin.routes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class BackendController {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        return "Vue.js Test Text 2";
    }


}
