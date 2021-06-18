package ito.akira.hexagonal.api.infraestructure.respository.convert;

import ito.akira.hexagonal.api.core.student.Student;
import ito.akira.hexagonal.api.infraestructure.respository.StudentEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterStudentEntity implements Converter<Student, StudentEntity> {

    @Override
    public StudentEntity convert(Student source) {
        return StudentEntity.builder().id(source.getId()).name(source.getName()).active(source.isActive())
                .birthdate(source.getBirthdate()).build();
    }

}
