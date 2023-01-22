package com.java.facultyms.controllers;

import com.java.facultyms.models.entity.Teacher;
import com.java.facultyms.models.response.TeachersResponse;
import com.java.facultyms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teacher/hello-world/{input}")
    public String getHelloWorld(@PathVariable("input") String input) {
        return "Hello World from faculty" + input;
    }

    @GetMapping("/api/teachers/{classname}")
    public ResponseEntity<?> findTeachersByClassName(@PathVariable("classname") String input) {
        List<Teacher> teacherList = teacherRepository.findByClassNameEquals(input);
        List<TeachersResponse> teachersResponseList = new ArrayList<>();
        teacherList.forEach(teacher -> {
            TeachersResponse teachersResponse = TeachersResponse.builder()
                    .teacherName(teacher.getTeacherName())
                    .teacherTitle(teacher.getTeacherTitle())
                    .phoneNumber(teacher.getPhoneNumber())
                    .emailId(teacher.getEmailId())
                    .className(teacher.getClassName())
                    .build();
            teachersResponseList.add(teachersResponse);
        });
        return ResponseEntity.ok().body(teacherList);
    }
}
