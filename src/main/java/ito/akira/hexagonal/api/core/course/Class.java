package ito.akira.hexagonal.api.core.course;

import java.util.List;

import ito.akira.hexagonal.api.core.student.Student;
import lombok.Getter;

@Getter
public class Class {
	private List<Student> students;
	private String name;
}
