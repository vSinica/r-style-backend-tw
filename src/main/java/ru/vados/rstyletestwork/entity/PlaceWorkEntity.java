package ru.vados.rstyletestwork.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "place_work")
public class PlaceWorkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private LocalDate dateBegin;

    private LocalDate dateEnd;

    private String position;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeEntity employee;

    public PlaceWorkEntity() {
    }

    public PlaceWorkEntity update(PlaceWorkEntity updated){
        return PlaceWorkEntity.builder()
                .id(updated.getId())
                .position(updated.getPosition())
                .dateEnd(updated.getDateEnd())
                .dateBegin(updated.getDateBegin())
                .companyName(updated.companyName)
                .employee(updated.getEmployee())
                .build();
    }

}
