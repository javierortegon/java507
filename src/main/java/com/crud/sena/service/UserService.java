package com.crud.sena.service;

import com.crud.sena.entity.User;
import com.crud.sena.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public List<User> getUsers(){
        return iUserRepository.findAll();
    }

    public User saveUser(User user){
        return iUserRepository.save(user);
    }

    public User getUser(Long id){
        return iUserRepository.findById(id).get();
    }

    public User updateUser(User user){
        return iUserRepository.save(user);
    }

    public void deleteUser(Long id){
        iUserRepository.deleteById(id);
    }

}
