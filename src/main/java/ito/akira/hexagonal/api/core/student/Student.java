package ito.akira.hexagonal.api.core.student;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

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
