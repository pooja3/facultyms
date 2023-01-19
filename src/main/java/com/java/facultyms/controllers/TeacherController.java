package com.java.facultyms.controllers;

import com.java.facultyms.models.entity.Teacher;
import com.java.facultyms.models.request.TeacherWithClassAndSubject;
import com.java.facultyms.models.response.TeacherWithAttendance;
import com.java.facultyms.models.response.TeacherWithClassAndSubjectResponse;
import com.java.facultyms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/api/teacher/find-by-class-subject")
    public ResponseEntity<?> findTeachersByClassAndSubject(@RequestBody TeacherWithClassAndSubject teacherWithClassAndSubject) {
        List<Teacher> teacherList = teacherRepository
                .findByClassNameEqualsAndSubject_SubjectNameContainsOrderByTeacherNameAsc(
                        teacherWithClassAndSubject.getClassName(),
                        teacherWithClassAndSubject.getSubjectName()
                );

        if (teacherList.isEmpty()) {
            return ResponseEntity.badRequest().body("No teacher found");
        }

        List<TeacherWithClassAndSubjectResponse> teacherWithClassAndSubjectResponseList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            TeacherWithClassAndSubjectResponse teacherWithClassAndSubjectResponse = TeacherWithClassAndSubjectResponse.builder()
                    .className(teacher.getClassName())
                    .subjectName(teacher.getSubject().getSubjectName())
                    .teacherName(teacher.getTeacherName())
                    .build();
            teacherWithClassAndSubjectResponseList.add(teacherWithClassAndSubjectResponse);
        }
        return ResponseEntity.ok().body(teacherWithClassAndSubjectResponseList);
    }

    @GetMapping("/api/teacher/find-teacher-attendance")
    public ResponseEntity<?> findTeachersByAttendanceAndClass(@RequestBody TeacherWithClassAndSubject teacherWithClassAndSubject) {
        List<Teacher> teacherList = teacherRepository
                .findByClassNameEqualsAndSubject_SubjectNameContainsOrderByTeacherNameAsc(
                        teacherWithClassAndSubject.getClassName(),
                        teacherWithClassAndSubject.getSubjectName()
                );

        if (teacherList.isEmpty()) {
            return ResponseEntity.badRequest().body("No teacher found");
        }

        List<TeacherWithAttendance> teacherWithAttendanceList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            TeacherWithAttendance teacherWithAttendance = TeacherWithAttendance.builder()
                    .teacherName(teacher.getTeacherName())
                    .className(teacher.getClassName())
                    .attendance(teacher.getAttendance().toString() + "%")
                    .build();
            teacherWithAttendanceList.add(teacherWithAttendance);
        }
        return ResponseEntity.ok().body(teacherWithAttendanceList);
    }
}
