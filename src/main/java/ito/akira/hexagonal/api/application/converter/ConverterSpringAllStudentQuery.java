package ito.akira.hexagonal.api.application.converter;

import ito.akira.hexagonal.api.application.http.dto.AllStudentQueryDTO;
import ito.akira.hexagonal.api.core.student.dto.AllStudentQuery;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterSpringAllStudentQuery implements Converter<AllStudentQueryDTO, AllStudentQuery> {

    @Override
    public AllStudentQuery convert(AllStudentQueryDTO source) {
        return new AllStudentQuery(source.getName());
    }
}
