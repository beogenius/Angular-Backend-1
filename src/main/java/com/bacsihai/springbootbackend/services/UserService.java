package com.bacsihai.springbootbackend.services;

import com.bacsihai.springbootbackend.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    Iterable<User> getAllUser();
    User saveUser(User user);
    User getUserByID(long id);
    void delete(long id);
    void deleteAll(long[] ids);
}
