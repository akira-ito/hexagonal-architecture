package ito.akira.hexagonal.api.application.http.spring;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ito.akira.hexagonal.api.application.http.dto.AllStudentQueryDTO;
import ito.akira.hexagonal.api.application.http.dto.CreateStudentDTO;
import ito.akira.hexagonal.api.application.http.dto.StudentDTO;
import ito.akira.hexagonal.api.application.http.dto.UpdateStatusStudentDTO;
import ito.akira.hexagonal.api.core.exceptions.StudentNotFoundException;
import ito.akira.hexagonal.api.core.student.Student;
import ito.akira.hexagonal.api.core.student.dto.AllStudentQuery;
import ito.akira.hexagonal.api.core.student.dto.UpdateActiveStatusStudent;
import ito.akira.hexagonal.api.core.student.dto.UpdateInformationStudentDTO;
import ito.akira.hexagonal.api.core.student.port.StudentServicePort;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@Api("Estudantes")
public class StudentController {
    private final StudentServicePort studentService;
    private final ConversionService conversionService;

    @GetMapping
    @ApiOperation("Buscar/Filtrar todos os estudantes")
    public List<StudentDTO> getAllStudents(AllStudentQueryDTO allStudentQueryDTO) {
        AllStudentQuery query = this.conversionService.convert(allStudentQueryDTO, AllStudentQuery.class);
        return this.studentService.getAll(query).stream()
                .map(student -> this.conversionService.convert(student, StudentDTO.class)).collect(Collectors.toList());
    }

    @PostMapping
    public void createStudent(@RequestBody CreateStudentDTO body) {
        Student student = this.conversionService.convert(body, Student.class);
        this.studentService.create(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        boolean exists = this.studentService.existById(id);
        if (!exists)
            throw new StudentNotFoundException("Student Not found");

        this.studentService.deleteById(id);
    }

    @PatchMapping("/{id}/status")
    public void updateStatus(@PathVariable("id") Long id, @Valid @RequestBody UpdateStatusStudentDTO body) {
        UpdateActiveStatusStudent status = this.conversionService.convert(body, UpdateActiveStatusStudent.class);
        this.studentService.updateActiveStatusById(id, status);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateInformamtion(@PathVariable("id") Long id, @Valid @RequestBody UpdateInformationStudentDTO body) {
        this.studentService.updateInformation(id, body);
    }
}
