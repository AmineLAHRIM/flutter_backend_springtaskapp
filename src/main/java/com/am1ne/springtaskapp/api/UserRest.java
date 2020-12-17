package com.am1ne.springtaskapp.api;

import com.am1ne.springtaskapp.beans.User;
import com.am1ne.springtaskapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("taskapp/user")
public class UserRest {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> findAll() {
        System.out.println("findall rest");
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    @PostMapping("/")
    public int save(@RequestBody User user) {
        return this.userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return this.userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable Long id) {
        return this.userService.deleteById(id);
    }


    @GetMapping("/login")
    public User findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return this.userService.findByEmailAndPassword(email, password);
    }
}
