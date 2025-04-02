package com.campaigns.task.routing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping(value = {"/", "/new", "/edit"})
    public String redirect() {
        return "forward:/index.html";
    }
}
