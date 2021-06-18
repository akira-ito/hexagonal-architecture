package ito.akira.hexagonal.api.core.course.port;

import ito.akira.hexagonal.api.core.course.Class;

import java.util.List;

public interface ClassServicePort {
    public List<Class> findAll();

    public void create(Class clazz);
}
