package ito.akira.hexagonal.api.application.http.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class UpdateStatusStudentDTO {
	
	@NotNull
	public boolean status;
}
