package kr.geun.oss.admin.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BackendController {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        return "Vue.js Test Text 2";
    }
}
