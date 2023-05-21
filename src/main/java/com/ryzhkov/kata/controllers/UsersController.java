package com.ryzhkov.kata.controllers;

import com.ryzhkov.kata.models.User;
import com.ryzhkov.kata.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "getUser";
    }

    @GetMapping("/new")
    public String openNewUserForm(@ModelAttribute("user") User user) {
        return "newUserForm";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String openEditUserForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "editUserForm";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                             @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
