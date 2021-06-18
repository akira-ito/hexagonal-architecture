package ito.akira.hexagonal.api.infraestructure.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentSpringJpaRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findAllByName(String name);

    @Modifying
    @Query("UPDATE StudentEntity s SET s.active = :active WHERE s.id = :id")
    void updateActiveStatusById(@Param("id") Long id, @Param("active") boolean active);
}
