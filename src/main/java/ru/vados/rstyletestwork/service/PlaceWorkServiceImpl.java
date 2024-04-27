package ru.vados.rstyletestwork.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vados.rstyletestwork.dto.PlaceWorkDto;
import ru.vados.rstyletestwork.entity.PlaceWorkEntity;
import ru.vados.rstyletestwork.repository.EmployeRepository;
import ru.vados.rstyletestwork.repository.PlaceWorkRepository;

@Service
@AllArgsConstructor
public class PlaceWorkServiceImpl implements PlaceWorkService{

    private final PlaceWorkRepository placeWorkRepository;
    private final EmployeRepository employeRepository;

    @Override
    public void createPlaceWork(PlaceWorkDto placeWorkDto) {
        final var entity = convert(placeWorkDto);
        placeWorkRepository.save(entity);
    }

    @Override
    public PlaceWorkDto getPlaceWorkById(Long placeWorkId) {
        return convert(placeWorkRepository.findById(placeWorkId).orElseThrow());
    }

    @Override
    public void updatePlaceWork(PlaceWorkDto placeWorkDto) {
        final var entity = placeWorkRepository.findById(placeWorkDto.getId()).orElseThrow();
        entity.update(convert(placeWorkDto));
        placeWorkRepository.save(entity);
    }

    @Override
    public void deletePlaceWork(Long placeWorkId) {

    }

    public PlaceWorkEntity convert(PlaceWorkDto placeWorkDto){
        return PlaceWorkEntity.builder()
                .companyName(placeWorkDto.getCompanyName())
                .dateBegin(placeWorkDto.getDateBegin())
                .dateEnd(placeWorkDto.getDateEnd())
                .employee(placeWorkDto.getEmployeeId() != null ?
                        employeRepository.findById(placeWorkDto.getEmployeeId()).orElseGet(null)
                        : null)
                .position(placeWorkDto.getPosition())
                .id(placeWorkDto.getId())
                .build();
    }

    public PlaceWorkDto convert(PlaceWorkEntity placeWorkEntity){
        return PlaceWorkDto.builder()
                .id(placeWorkEntity.getId())
                .companyName(placeWorkEntity.getCompanyName())
                .dateBegin(placeWorkEntity.getDateBegin())
                .dateEnd(placeWorkEntity.getDateEnd())
                .employeeId(placeWorkEntity.getEmployee().getId())
                .position(placeWorkEntity.getPosition())
                .build();
    }
}
