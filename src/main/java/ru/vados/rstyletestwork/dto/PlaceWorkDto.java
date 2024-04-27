package ru.vados.rstyletestwork.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PlaceWorkDto {
    private Long id;

    private String companyName;

    private LocalDate dateBegin;

    private LocalDate dateEnd;

    private String position;

    private Long employeeId;
}
