package com.caroca.Caroca_Mesi.Controller;

import com.caroca.Caroca_Mesi.Model.User;
import com.caroca.Caroca_Mesi.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
}