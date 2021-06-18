package ito.akira.hexagonal.api.core.student;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Student {
	private Long id;
	private String name;
	private boolean active;
	private LocalDate birthdate;
	
	public void updateInformation(String name, LocalDate birthdate) {
		this.name = name;
		this.birthdate = birthdate;
	}
}
