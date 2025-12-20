package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService{
    User postData(User use);
    List<User>getAllData();
    String  DeleteData(int id);
    User getData(int id);         
    User updateData(int id,User entity);                                                        
}