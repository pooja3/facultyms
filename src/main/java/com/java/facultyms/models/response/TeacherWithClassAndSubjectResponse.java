package com.java.facultyms.models.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherWithClassAndSubjectResponse {

    String teacherName;

    String className;

    String subjectName;
}
