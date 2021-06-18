package ito.akira.hexagonal.api.infraestructure.respository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@SelectBeforeUpdate
@DynamicInsert

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
