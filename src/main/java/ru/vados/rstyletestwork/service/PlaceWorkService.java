package ru.vados.rstyletestwork.service;

import ru.vados.rstyletestwork.dto.EmployeDto;
import ru.vados.rstyletestwork.dto.PlaceWorkDto;
import ru.vados.rstyletestwork.entity.PlaceWorkEntity;

public interface PlaceWorkService {
    void createPlaceWork(PlaceWorkDto placeWorkDto);
    PlaceWorkDto getPlaceWorkById(Long placeWorkId);
    void updatePlaceWork(PlaceWorkDto placeWorkDto);
    void deletePlaceWork(Long placeWorkId);

    PlaceWorkEntity convert(PlaceWorkDto placeWorkDto);

    PlaceWorkDto convert(PlaceWorkEntity placeWorkEntity);
}
