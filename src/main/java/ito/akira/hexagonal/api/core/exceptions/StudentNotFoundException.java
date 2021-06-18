package ito.akira.hexagonal.api.core.exceptions;

public class StudentNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 166177298712365623L;

    public StudentNotFoundException(String message) {
        super(message);
    }

}
