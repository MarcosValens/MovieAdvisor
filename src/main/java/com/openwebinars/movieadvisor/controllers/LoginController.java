package com.openwebinars.movieadvisor.controllers;

import com.openwebinars.movieadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /*@PostMapping("/login")
    public String loginForm(@RequestParam("user") String userName, @RequestParam("password") String password) {
        if (userService.isValidUser(userName, password)) {
            return "genres";
        } else {
            return "login";
        }
    }*/

    @PostMapping("/login")
    public RedirectView loginForm(@RequestParam("user") String userName, @RequestParam("password") String password, HttpSession httpSession) {
        if (userService.isValidUser(userName, password)) {
            httpSession.setAttribute("validate","YES");
            return new RedirectView("./genres");
        } else {
            return new RedirectView("./login");
        }
    }
}
