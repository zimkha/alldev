package com.stuff.dev.alldev.services;

import com.stuff.dev.alldev.entities.Technology;
import com.stuff.dev.alldev.repositories.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@RequiredArgsConstructor
@Service
@Slf4j
public class TechnologyServiceImpl implements TechnologyService {
    private  final TechnologyRepository technologyRepository;
    @Override
    public Technology created(Technology technology) {
        return technologyRepository.save(technology);
    }
    @Override
    public Collection<Technology> list(int limit) {
        return technologyRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Boolean deleted(Long id) {
         technologyRepository.deleteById(id);
        return true;
    }

    @Override
    public Technology getOne(Long id) {
        return technologyRepository.findById(id).get();
    }
}
