package com.java.facultyms.models.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherWithClassAndSubject {

    String className;

    String subjectName;
}
