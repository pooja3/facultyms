package com.java.facultyms.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacherId")
    Long teacherId;

    String teacherName;

    String emailId;

    String phoneNumber;

    String teacherTitle;

    String qualifications;

    String className;

    Float attendance;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    Subject subject;
}
