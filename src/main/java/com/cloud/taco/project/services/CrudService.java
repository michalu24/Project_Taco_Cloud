package com.cloud.taco.project.services;

import java.util.Set;

public interface CrudService<T,I> {

    T save(T object);

    Set<T> findAll();

    T findById(I id);

    void delete(T object);

    void deleteById(I id);

    void update(T object);
}
