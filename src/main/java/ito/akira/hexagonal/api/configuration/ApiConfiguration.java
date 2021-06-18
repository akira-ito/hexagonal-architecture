package ito.akira.hexagonal.api.configuration;

import ito.akira.hexagonal.api.core.student.StudentService;
import ito.akira.hexagonal.api.core.student.port.StudentRepositoryPort;
import ito.akira.hexagonal.api.core.student.port.StudentServicePort;
import ito.akira.hexagonal.api.infraestructure.respository.StudentJpaRepository;
import ito.akira.hexagonal.api.infraestructure.respository.StudentSpringJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
@AllArgsConstructor
public class ApiConfiguration {
    private final StudentSpringJpaRepository studentSpringJpaRepository;
    private final ConversionService conversionService;

    @Bean
    public StudentRepositoryPort studentPersistence() {
        return new StudentJpaRepository(studentSpringJpaRepository, conversionService);
    }

    @Bean
    public StudentServicePort studentService() {
        return new StudentService(studentPersistence());
    }
}