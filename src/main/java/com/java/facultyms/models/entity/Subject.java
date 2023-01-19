package com.java.facultyms.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subjectId")
    Long subjectId;

    String subjectName;

    @OneToMany(mappedBy = "subject")
    List<Teacher> teacherList = new ArrayList<>();
}
