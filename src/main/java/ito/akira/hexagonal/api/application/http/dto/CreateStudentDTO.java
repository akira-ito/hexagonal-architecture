package ito.akira.hexagonal.api.application.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentDTO {
    private String name;
    private LocalDate birthdate;
}
