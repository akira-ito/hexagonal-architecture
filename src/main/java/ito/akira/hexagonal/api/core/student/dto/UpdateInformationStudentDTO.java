package ito.akira.hexagonal.api.core.student.dto;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class UpdateInformationStudentDTO {
	private String name;
	private LocalDate birthdate;
}
