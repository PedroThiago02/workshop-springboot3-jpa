package com.javacourseexercise.course.resources;

import com.javacourseexercise.course.entites.User;
import com.javacourseexercise.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
         User userById = userService.findById(id);
        return ResponseEntity.ok().body(userById);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User userInsert){
        userInsert = userService.insert(userInsert);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userInsert.getId()).toUri();
        return ResponseEntity.created(uri).body(userInsert);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User body){
        User updatedUser = userService.update(id, body);
        return ResponseEntity.ok().body(updatedUser);
    }
}
