package com.java.facultyms.repository;

import com.java.facultyms.models.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByClassNameEquals(String className);

}
