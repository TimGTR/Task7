package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public String getUsers(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("Kolya", "Petrov"));
        model.addAttribute("users", users);
        return "users";
    }
}