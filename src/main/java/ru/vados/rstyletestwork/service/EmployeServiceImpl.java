package ru.vados.rstyletestwork.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vados.rstyletestwork.dto.EmployeDto;
import ru.vados.rstyletestwork.entity.EmployeEntity;
import ru.vados.rstyletestwork.repository.EmployeRepository;
import ru.vados.rstyletestwork.repository.PlaceWorkRepository;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService{

    private final EmployeRepository employeRepository;
    private final PlaceWorkService placeWorkService;
    private final PlaceWorkRepository placeWorkRepository;

    @Override
    @Transactional
    public void createEmploye(EmployeDto employeDto) {
        final var entity = convert(employeDto);
        entity.getPlaceWorkList().forEach(a -> a.setEmployee(entity));
        employeRepository.save(entity);
        placeWorkRepository.saveAll(entity.getPlaceWorkList());
    }

    @Override
    @Transactional
    public EmployeDto getEmployeById(Long employeId) {
        return convert(employeRepository.findById(employeId).orElseThrow());
    }

    @Override
    @Transactional
    public void updateEmploye(EmployeDto employeDto) {
        final var entity = employeRepository.findById(employeDto.getId()).orElseThrow();
        entity.update(convert(employeDto));
        employeRepository.save(entity);
    }

    @Override
    public void deleteEmploye(Long employeId) {

    }

    public EmployeEntity convert(EmployeDto dto){
        return EmployeEntity.builder()
                .id(dto.getId())
                .aboutMe(dto.getAboutMe())
                .age(dto.getAge())
                .competencies(dto.getCompetencies())
                .email(dto.getEmail())
                .location(dto.getLocation())
                .specialization(dto.getSpecialization())
                .placeWorkList(dto.getPlaceWorkList().stream()
                        .map(placeWorkService::convert)
                        .collect(Collectors.toList())
                )
                .build();
    }

    public EmployeDto convert(EmployeEntity entity){
        return EmployeDto.builder()
                .id(entity.getId())
                .aboutMe(entity.getAboutMe())
                .age(entity.getAge())
                .competencies(entity.getCompetencies())
                .email(entity.getEmail())
                .location(entity.getLocation())
                .specialization(entity.getSpecialization())
                .placeWorkList(entity.getPlaceWorkList().stream()
                        .map(placeWorkService::convert)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
