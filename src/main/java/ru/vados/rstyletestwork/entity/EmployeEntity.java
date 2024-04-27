package ru.vados.rstyletestwork.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "employe")
@AllArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class EmployeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialization;

    private String email;

    private String location;

    private String aboutMe;

    private LocalDate age;

    @Type(type = "jsonb")
    @Column(name = "competencies", columnDefinition = "jsonb")
    private List<String> competencies;

    @OneToMany(mappedBy = "employee")
    private List<PlaceWorkEntity> placeWorkList;

    public EmployeEntity() {
    }

    public EmployeEntity update(EmployeEntity updated) {
        return EmployeEntity.builder()
                .id(updated.getId())
                .placeWorkList(updated.getPlaceWorkList())
                .specialization(updated.getSpecialization())
                .location(updated.getLocation())
                .competencies(updated.getCompetencies())
                .age(updated.getAge())
                .aboutMe(updated.getAboutMe())
                .email(updated.getEmail())
                .build();
    }
}
