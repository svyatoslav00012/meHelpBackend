package meHelpCoders.MeHelpBackend.controllers;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String getMainPage(){
        return "Main page will be here";
    }

}
