package ito.akira.hexagonal.api.core.course.port;

import java.util.List;

import ito.akira.hexagonal.api.core.course.Class;

public interface ClassServicePort {
	public List<Class> findAll();
	public void create(Class clazz);
}
