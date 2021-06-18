package ito.akira.hexagonal.api.infraestructure.respository.convert;

import java.util.Objects;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import ito.akira.hexagonal.api.core.student.Student;
import ito.akira.hexagonal.api.infraestructure.respository.StudentEntity;

@Service
public class ConverterStudent implements Converter<StudentEntity, Student> {

	@Override
	public Student convert(StudentEntity source) {
		if (Objects.isNull(source))
			return null;

		return Student.of(source.getId(), source.getName(), source.isActive(), source.getBirthdate());
	}

}
