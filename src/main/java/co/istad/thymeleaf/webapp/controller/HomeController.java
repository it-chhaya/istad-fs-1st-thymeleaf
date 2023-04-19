package co.istad.thymeleaf.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    String viewHome() {
        return "pages/index";
    }

}
