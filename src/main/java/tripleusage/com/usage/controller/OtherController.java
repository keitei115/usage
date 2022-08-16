package tripleusage.com.usage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {
    @GetMapping("/overview")
    public String getOverview(Model model) {
        return "overview";
    }
}
