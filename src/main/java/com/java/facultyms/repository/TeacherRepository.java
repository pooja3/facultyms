package com.java.facultyms.repository;

import com.java.facultyms.models.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select t from Teacher t " +
            "where t.className = ?1 and t.subject.subjectName like concat('%', ?2, '%') " +
            "order by t.teacherName")
    List<Teacher> findByClassNameEqualsAndSubject_SubjectNameContainsOrderByTeacherNameAsc(String className, String subjectName);


}
