package com.am1ne.springtaskapp.services;

import com.am1ne.springtaskapp.beans.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(Long id);

    public int save(User user);

    public int deleteById(Long id);

    User update(Long id, User user);

    User findByEmailAndPassword(String email, String password);
}
