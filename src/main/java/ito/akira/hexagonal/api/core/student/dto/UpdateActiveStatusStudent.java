package ito.akira.hexagonal.api.core.student.dto;

import lombok.Getter;

@Getter
public class UpdateActiveStatusStudent {
    private boolean status;

    public UpdateActiveStatusStudent(boolean status) {
        this.status = status;
    }
}
