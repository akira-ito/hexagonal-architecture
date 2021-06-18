package ito.akira.hexagonal.api.core.student.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UpdateInformationStudentDTO {
    private String name;
    private LocalDate birthdate;
}
