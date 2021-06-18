package ito.akira.hexagonal.api.application.converter;

import ito.akira.hexagonal.api.application.http.dto.UpdateStatusStudentDTO;
import ito.akira.hexagonal.api.core.student.dto.UpdateActiveStatusStudent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterSpringUpdateStatusStudentDTO implements Converter<UpdateStatusStudentDTO, UpdateActiveStatusStudent> {

    @Override
    public UpdateActiveStatusStudent convert(UpdateStatusStudentDTO source) {
        return new UpdateActiveStatusStudent(source.isStatus());
    }
}
