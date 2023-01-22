package com.java.facultyms.models.response;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class TeachersResponse {

    String teacherName;

    String emailId;

    String phoneNumber;

    String teacherTitle;

    String className;

}