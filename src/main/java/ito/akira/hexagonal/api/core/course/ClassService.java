package ito.akira.hexagonal.api.core.course;

import ito.akira.hexagonal.api.core.course.port.ClassServicePort;

import java.util.List;

public class ClassService implements ClassServicePort {

    @Override
    public List<Class> findAll() {
        return null;
    }

    @Override
    public void create(Class clazz) {

    }

}
