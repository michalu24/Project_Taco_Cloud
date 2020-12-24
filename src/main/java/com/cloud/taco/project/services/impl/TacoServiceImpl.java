package com.cloud.taco.project.services.impl;

import com.cloud.taco.project.domain.Taco;
import com.cloud.taco.project.repositories.TacoRepository;
import com.cloud.taco.project.services.TacoService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Taco repository
 * @author Michał Urbański
 */

@Service
public class TacoServiceImpl implements TacoService {

    TacoRepository repository;

    public TacoServiceImpl(TacoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Taco save(Taco object) {
        return repository.save(object);
    }

    @Override
    public Set<Taco> findAll() {
        Set<Taco> tacos = new LinkedHashSet<>();
        repository.findAll().iterator().forEachRemaining(tacos::add);
        return tacos;
    }

    @Override
    public Taco findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Taco object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Taco object) {
        repository.save(object);
    }
}
