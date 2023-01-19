package com.java.facultyms.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@NamedQueries({
        @NamedQuery(name = "Teacher.findByClassNameEqualsAndSubject_SubjectNameContainsOrderByTeacherNameAsc", query = "select t from Teacher t where t.className = :className and t.subject.subjectName like concat('%', :subjectName, '%') order by t.teacherName")
})
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
