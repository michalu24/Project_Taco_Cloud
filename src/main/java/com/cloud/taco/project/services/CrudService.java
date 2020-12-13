package com.cloud.taco.project.services;

import java.util.Set;

/**
 * Base service for others services to implement
 * in the project
 *
 * @param <T> - Entity class
 * @param <I> - Entity id class
 * @author Michał Urbański
 */
public interface CrudService<T,I> {

    /**
     *
     * @param object - of specified class T
     * @return - method saves object to DB
     */

    T save(T object);

    /**
     * Method finds all entities in DB
     * @return - set of entities
     */
    Set<T> findAll();

    /**
     * Method search for entity by it's id
     * @param id - entity id
     * @return - entity
     */
    T findById(I id);

    /**
     * Method deletes entity from DB
     * @param object - entity to be removed
     */
    void delete(T object);

    /**
     * Method deletes entity from DB by it's id
     * @param id - entity id
     */
    void deleteById(I id);

    /**
     * Method updates entity in DB
     * @param object - entity to be updated
     */
    void update(T object);
}
