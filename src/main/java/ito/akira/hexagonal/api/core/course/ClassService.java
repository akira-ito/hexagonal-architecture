package ito.akira.hexagonal.api.core.course;

import java.util.List;

import ito.akira.hexagonal.api.core.course.port.ClassServicePort;

public class ClassService implements ClassServicePort {

	@Override
	public List<Class> findAll() {
		return null;
	}

	@Override
	public void create(Class clazz) {
		
	}

}
