package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = new User(null, request.getName(), request.getEmail(), request.getPassword(), User.ROLE_USER);
        return ResponseEntity.ok(userService.register(user));
    }
}




// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import jakarta.validation.Valid;

// @RequestMapping("/User")
// @RestController
// public class UserController{
//     @Autowired  UserService ser;
//     @PostMapping("/register")
//     public User sendData(@RequestBody User stu){
//         return ser.postData1(stu);
//     }
//     @PostMapping("/login")
//     public User senddata(@RequestBody User log){
//         return ser.postdata(log);
//     }
//     @GetMapping("/get")
//     public List<User> getval(){
//         return ser.getAllData1();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData1(id);
//     }
//     @GetMapping("/find/{id}")
//     public User find(@PathVariable Long id){
//         return ser.getData1(id);
//     }
//     @PutMapping("/put/{id}")
//     public User putval(@PathVariable Long id,@RequestBody User entity){
//         return ser.updateData1(id,entity);
//     }
// }