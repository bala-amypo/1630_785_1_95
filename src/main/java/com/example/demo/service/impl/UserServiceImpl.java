package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already registered");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
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