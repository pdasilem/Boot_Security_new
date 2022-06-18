package ru.pdasilem.spring.security.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pdasilem.spring.security.model.UserModel;
import ru.pdasilem.spring.security.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUser1(@AuthenticationPrincipal UserModel userModel, Model model) {
        UserModel user = userService.getUserById(userModel.getId());
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        UserModel user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }
}
