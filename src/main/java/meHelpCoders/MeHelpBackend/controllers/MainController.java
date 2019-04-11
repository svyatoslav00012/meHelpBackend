package meHelpCoders.MeHelpBackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/{path:[^\\.]+}/**")
    public String redirectToIndex(){
        return "forward:/";
    }

}
