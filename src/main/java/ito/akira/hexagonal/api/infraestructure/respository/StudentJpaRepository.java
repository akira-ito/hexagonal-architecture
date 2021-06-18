package ito.akira.hexagonal.api.infraestructure.respository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.core.convert.ConversionService;

import ito.akira.hexagonal.api.core.student.Student;
import ito.akira.hexagonal.api.core.student.port.StudentRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentJpaRepository implements StudentRepositoryPort {
	private final StudentSpringJpaRepository repository;
	private final ConversionService conversionService;

	@Override
	public List<Student> findAll() {
		return this.repository.findAll().stream().map(student -> this.conversionService.convert(student, Student.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> findAllByName(String name) {
		return this.repository.findAllByName(name).stream()
				.map(student -> this.conversionService.convert(student, Student.class)).collect(Collectors.toList());
	}

	@Override
	public void create(Student student) {
		StudentEntity studentEntity = this.conversionService.convert(student, StudentEntity.class);
		this.repository.save(studentEntity);
	}

	@Override
	public boolean existById(Long id) {
		return this.repository.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateActiveStatusById(Long id, boolean active) {
		this.repository.updateActiveStatusById(id, active);
	}

	@Override
	public Optional<Student> findOneById(Long id) {
		return Optional
				.ofNullable(this.conversionService.convert(this.repository.findById(id).orElse(null), Student.class));
	}

	@Override
	public void update(Student student) {
		this.repository.save(this.conversionService.convert(student, StudentEntity.class));

 	}

}
