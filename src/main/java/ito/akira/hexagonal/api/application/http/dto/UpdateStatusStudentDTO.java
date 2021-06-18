package ito.akira.hexagonal.api.application.http.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateStatusStudentDTO {

    @NotNull
    public boolean status;
}
