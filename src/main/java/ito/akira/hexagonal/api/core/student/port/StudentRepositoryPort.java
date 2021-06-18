package ito.akira.hexagonal.api.core.student.port;

import ito.akira.hexagonal.api.core.student.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryPort {
    public List<Student> findAll();

    public List<Student> findAllByName(String name);

    public void create(Student student);

    public boolean existById(Long id);

    public void deleteById(Long id);

    public void updateActiveStatusById(Long id, boolean active);

    public Optional<Student> findOneById(Long id);

    public void update(Student student);
}
