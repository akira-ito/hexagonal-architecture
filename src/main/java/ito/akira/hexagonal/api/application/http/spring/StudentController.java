package ito.akira.hexagonal.api.application.http.spring;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
