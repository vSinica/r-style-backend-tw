package ru.vados.rstyletestwork.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class EmployeDto {
    private Long id;

    private String specialization;

    private String email;

    private String location;

    private String aboutMe;

    private LocalDate age;

    private List<String> competencies;

    private List<PlaceWorkDto> placeWorkList;
}
