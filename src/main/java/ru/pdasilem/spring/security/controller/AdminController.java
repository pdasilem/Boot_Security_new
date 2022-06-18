package ru.pdasilem.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pdasilem.spring.security.model.Roles;
import ru.pdasilem.spring.security.model.UserModel;
import ru.pdasilem.spring.security.service.RoleService;
import ru.pdasilem.spring.security.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    private static final String REDIRECT_ADMIN = "redirect:/admin";


    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/newuser")
    public String newUser(Model model) {
        model.addAttribute("user", new UserModel());
        return "newuser";
    }

    @PostMapping("/newuser")
    public String createUser(@RequestParam("userLogin") String userLogin,
                             @RequestParam("password") String password,
                             @RequestParam("name") String name,
                             @RequestParam("surName") String surName,
                             @RequestParam("age") Integer age,
                             @RequestParam("email") String email,
                             @RequestParam("roles") Long[] role) {
        Set<Roles> roleSet = new HashSet<>();
        for (Long roles : role) {
            roleSet.add(roleService.findRoleById(roles));
        }
        userService.save(new UserModel(userLogin, password, name, surName, age, email, roleSet));
        return REDIRECT_ADMIN;
    }

    @GetMapping("/{id}/update")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id,
                             @RequestParam("userLogin") String userLogin,
                             @RequestParam("password") String password,
                             @RequestParam("name") String name,
                             @RequestParam("surName") String surName,
                             @RequestParam("age") Integer age,
                             @RequestParam("email") String email,
                             @RequestParam("roles") Long[] role) {
        Set<Roles> roleSet = new HashSet<>();
        for (Long roles : role) {
            roleSet.add(roleService.findRoleById(roles));
        }

        userService.updateUser(new UserModel(userLogin, password, name, surName, age, email, roleSet), id);
        return REDIRECT_ADMIN;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return REDIRECT_ADMIN;
    }


    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        UserModel user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }

}
