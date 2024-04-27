package ru.vados.rstyletestwork.service;

import ru.vados.rstyletestwork.dto.EmployeDto;

public interface EmployeService {
    void createEmploye(EmployeDto employeDto);
    EmployeDto getEmployeById(Long employeId);
    void updateEmploye(EmployeDto employeDto);
    void deleteEmploye(Long employeId);
}

