package com.javacourseexercise.course.services;

import com.javacourseexercise.course.entites.User;
import com.javacourseexercise.course.repositories.UserRepository;
import com.javacourseexercise.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return  obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User body){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, body);
        return userRepository.save(entity);
    }

    public void updateData(User entity, User body){
        entity.setName(body.getName());
        entity.setEmail(body.getEmail());
        entity.setPhone(body.getPhone());
        entity.setPassword(body.getPassword());
    }

}
