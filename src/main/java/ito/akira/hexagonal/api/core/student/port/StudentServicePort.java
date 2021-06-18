package ito.akira.hexagonal.api.core.student.port;

import java.util.List;

import ito.akira.hexagonal.api.core.student.Student;
import ito.akira.hexagonal.api.core.student.dto.AllStudentQuery;
import ito.akira.hexagonal.api.core.student.dto.UpdateActiveStatusStudent;
import ito.akira.hexagonal.api.core.student.dto.UpdateInformationStudentDTO;

public interface StudentServicePort {
	public List<Student> getAll(AllStudentQuery query);

	public void create(Student student);

	public boolean existById(Long id);

	public void deleteById(Long id);

	public void updateActiveStatusById(Long id, UpdateActiveStatusStudent body);

	public void updateInformation(Long id, UpdateInformationStudentDTO body);
}
