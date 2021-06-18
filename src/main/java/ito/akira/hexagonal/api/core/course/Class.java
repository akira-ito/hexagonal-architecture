package ito.akira.hexagonal.api.core.course;

import ito.akira.hexagonal.api.core.student.Student;
import lombok.Getter;

import java.util.List;

@Getter
public class Class {
    private List<Student> students;
    private String name;
}
