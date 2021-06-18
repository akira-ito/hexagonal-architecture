package ito.akira.hexagonal.api.application.converter;

import ito.akira.hexagonal.api.application.http.dto.CreateStudentDTO;
import ito.akira.hexagonal.api.core.student.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterSpringCreateStudentDTO implements Converter<CreateStudentDTO, Student> {

    @Override
    public Student convert(CreateStudentDTO source) {
        return Student.of(null, source.getName(), false, source.getBirthdate());
    }
}
