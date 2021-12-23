package com.example.zadanie20_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @RequestMapping("/users")
    public String list() {
        List<User> userList = userRepository.getAll();
        String result = "";
        for (User user1 : userList) {
            result += user1.getFirstName() + " " + user1.getLastName() + " wiek: " + user1.getAge() + "<br/>";
        }
        return result;
    }

    @RequestMapping("/add")
    public String add(@RequestParam String imie, @RequestParam(required = false) String nazwisko, @RequestParam(required = false, defaultValue = "0") Integer wiek) {
        if (!Objects.equals(imie, "")) {
            User user = new User(imie, nazwisko, wiek);
            userRepository.add(user);
            return "forward:/success.html";
        } else {
            return "forward:/err.html";
        }
    }

    @PostMapping("/addByForm")
    public String addByForm(@RequestParam String firstName, @RequestParam(required = false) String lastName, @RequestParam(required = false, defaultValue = "0") Integer age) {
        if (!Objects.equals(firstName, "")) {
            User user = new User(firstName, lastName, age);
            userRepository.add(user);
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }
}
