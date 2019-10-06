package kr.geun.oss.admin.routes.dashboard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * HomeWeb
 *
 * @author akageun
 * @since 2019-09-29
 */
@Slf4j
@Controller
public class HomeWeb {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping("/")
    public ModelAndView home(
    ) {
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }
}
