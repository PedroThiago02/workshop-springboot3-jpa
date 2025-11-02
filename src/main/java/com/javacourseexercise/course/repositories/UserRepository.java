package com.javacourseexercise.course.repositories;

import com.javacourseexercise.course.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
