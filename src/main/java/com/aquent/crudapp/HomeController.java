package com.aquent.crudapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class HomeController {
    /**
     * Redirect to the person list.
     * In a real application this could be our landing or login page.
     *
     * @return redirect to the person list
     */
    @GetMapping("/")
    public String index() {
        return "/home"; 
    }
}
