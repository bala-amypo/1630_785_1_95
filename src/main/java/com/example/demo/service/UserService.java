package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService{
    User postData1(User use);
    List<User>getAllData1();
    String  DeleteData1(int id);
    User getData1(int id);         
    User updateData1(int id,User entity);                                                        
}