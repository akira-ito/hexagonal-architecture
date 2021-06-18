package ito.akira.hexagonal.api.application.http.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
	private Long id;
	private String name;
	private boolean active;
	private LocalDate birthdate;
}
