package cc.tonny.multisecurityconfig.adapter.inbound;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/data")
    public String getData() {
        return "OK";
    }

    @GetMapping("/admin")
    public String getAdminData() {
        return "ADMIN ONLY";
    }
}
