package com.java.facultyms.models.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherWithAttendance {

    String teacherName;

    String className;

    String attendance;

    String subjectName;
}
