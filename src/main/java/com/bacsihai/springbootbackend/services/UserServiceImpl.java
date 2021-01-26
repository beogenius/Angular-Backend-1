package com.bacsihai.springbootbackend.services;

import com.bacsihai.springbootbackend.model.User;
import com.bacsihai.springbootbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUserByID(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = userRepository.findById(id).get();
        } else {
            throw new RuntimeException("User not found for id :" + id);
        }
        return user;
    }

    @Override
    public void delete(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void deleteAll(long[] ids) {
        this.userRepository.deleteAllByIdIsIn(ids);
    }
}
