package ito.akira.hexagonal.api.core.student;

import ito.akira.hexagonal.api.core.exceptions.StudentNotFoundException;
import ito.akira.hexagonal.api.core.student.dto.AllStudentQuery;
import ito.akira.hexagonal.api.core.student.dto.UpdateActiveStatusStudent;
import ito.akira.hexagonal.api.core.student.dto.UpdateInformationStudentDTO;
import ito.akira.hexagonal.api.core.student.port.StudentRepositoryPort;
import ito.akira.hexagonal.api.core.student.port.StudentServicePort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public final class StudentService implements StudentServicePort {
    private final StudentRepositoryPort studentRepository;
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public List<Student> getAll(AllStudentQuery query) {
        if (Objects.nonNull(query.getName()))
            return this.studentRepository.findAllByName(query.getName());
        return this.studentRepository.findAll();
    }

    @Override
    public void create(Student student) {
        this.studentRepository.create(student);
    }

    @Override
    public boolean existById(Long id) {
        return this.studentRepository.existById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public void updateActiveStatusById(Long id, UpdateActiveStatusStudent body) {
        this.studentRepository.updateActiveStatusById(id, body.isStatus());
    }

    @Override
    public void updateInformation(Long id, UpdateInformationStudentDTO body) {
        Student student = this.studentRepository.findOneById(id)
                .orElseThrow(() -> new StudentNotFoundException("Estudante não encontrado"));

        student.updateInformation(body.getName(), body.getBirthdate());
        this.studentRepository.update(student);
    }
}
