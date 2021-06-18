package ito.akira.hexagonal.api.infraestructure.respository;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate()
@SelectBeforeUpdate()
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default false")
    private boolean active;

    @Column(name = "birthdate")
    private LocalDate birthdate;

}
