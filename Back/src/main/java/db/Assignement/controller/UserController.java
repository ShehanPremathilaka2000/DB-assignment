package db.Assignement.controller;

import db.Assignement.model.User;
import db.Assignement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
@EnableTransactionManagement
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public boolean addUser(String name, String pin, int balance) {
        if(userService.addUser(name, pin, balance) == null){
            return false;
        }
        return true;
    }

    @PostMapping("/login")
    public boolean login(String name, String pin) {
        return userService.Login(name, pin);
    }

    @PostMapping("/getBalance")
    public int getBalance(String name) {
        return userService.getBalance(name);
    }

    @PostMapping("/transaction")
    public boolean transaction(String name, String receiverName, int amount) {
        return userService.transaction(name, receiverName, amount);
    }
}
