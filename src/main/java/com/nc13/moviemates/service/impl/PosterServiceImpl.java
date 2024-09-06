package com.nc13.moviemates.service.impl;

import com.nc13.moviemates.model.entity.PosterEntity;
import com.nc13.moviemates.model.entity.ScheduleEntity;
import com.nc13.moviemates.model.repository.PosterRepository;
import com.nc13.moviemates.service.PosterService;
import com.nc13.moviemates.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PosterServiceImpl implements PosterService {
    private final PosterRepository repository;

    @Override
    public List<PosterEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Boolean save(PosterEntity poster) {
        PosterEntity ent = repository.save(poster);
        Long id = ent.getId();
        return existsById(id);
    }

    @Override
    public Optional<PosterEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Boolean deleteById(Long id) {
         repository.deleteById(id);
        return !existsById(id);
    }
}
