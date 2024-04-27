package ru.vados.rstyletestwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vados.rstyletestwork.entity.EmployeEntity;

public interface EmployeRepository  extends JpaRepository<EmployeEntity, Long> {
}
