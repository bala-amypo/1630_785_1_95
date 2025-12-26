package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole(User.ROLE_USER);
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}


















// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.UserService;                

// @Service
// public class UserServiceImpl implements UserService{

//     @Autowired UserRepository used;
//     @Override
//     public User postData1(User use){
//         return used.save(use);  
//     }
//     @Override
//     public User postdata(User log){
//         return used.save(log);
//     }
//     @Override
//     public List<User>getAllData1(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData1(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public User getData1(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public User updateData1(Long id,User entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }