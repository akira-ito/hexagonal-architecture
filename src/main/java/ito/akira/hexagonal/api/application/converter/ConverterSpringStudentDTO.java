package ito.akira.hexagonal.api.application.converter;

import ito.akira.hexagonal.api.application.http.dto.StudentDTO;
import ito.akira.hexagonal.api.core.student.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterSpringStudentDTO implements Converter<Student, StudentDTO> {

    @Override
    public StudentDTO convert(Student source) {
        return StudentDTO.builder().id(source.getId()).name(source.getName()).active(source.isActive()).build();
    }
}
