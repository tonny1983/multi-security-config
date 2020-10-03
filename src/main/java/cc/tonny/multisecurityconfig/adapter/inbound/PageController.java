package cc.tonny.multisecurityconfig.adapter.inbound;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
}
