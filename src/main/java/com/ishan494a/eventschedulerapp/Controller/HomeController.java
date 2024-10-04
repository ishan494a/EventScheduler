package com.ishan494a.eventschedulerapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/userpage")
    public String secured(){
        return "This is a secured page";
    }


}
