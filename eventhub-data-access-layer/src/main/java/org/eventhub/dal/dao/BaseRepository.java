/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.BaseEntity;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 * @param <T> the domain type the repository manages
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {

    /**
     * soft delete an object
     * @param uuid the id of the entity
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query("update #{#entityName} e set e.deleted=true where e.uuid=?1")
    @Modifying
    @Transactional
    public void softDelete(UUID uuid);

    /**
     * soft delete an object
     *
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     * @param t the domain type the repository manages
     */
    @Query("update #{#entityName} e set e.deleted=true where e=?1")
    @Modifying
    @Override
    void delete(T t);

    /**
     * soft delete an object by ID
     *
     * @param uuid the id of the entity
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     *
     */
    @Query("update #{#entityName} e set e.deleted=true where e.uuid=?1")
    @Modifying
    @Transactional
    @Override
    void deleteById(UUID uuid);

    /**
     * retrieve the existing entities
     *
     * @param pageable set number and size of pages
     * @return list of entity
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query("from #{#entityName} e where e.deleted=0")
    @Override
    public Page<T> findAll(Pageable pageable);

    /**
     * retrieve all deleted entities
     *
     * @param pageable set number and size of pages
     * @return list of deleted entities
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query("from #{#entityName} e where e.deleted=1")
    public List<T> findAllDeleted(Pageable pageable);

    /**
     * retrieve deleted and undeleted entities
     *
     * @param <S> entity type
     * @param exmpl Example
     * @param sort Sorting data
     * @return List of entity
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Override
    @Query("from #{#entityName} e where e.deleted=0")
    public <S extends T> List<S> findAll(Example<S> exmpl, Sort sort);

    /**
     * retrieve deleted and undeleted entities
     *
     * @param <S> entity type
     * @param exmpl Example
     * @param pageable set number and size of pages
     * @return List of entity
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Override
    @Query("from #{#entityName} e where e.deleted=0")
    public <S extends T> Page<S> findAll(Example<S> exmpl, Pageable pageable);

    /**
     * retrieve undeleted entities by iterable of id
     *
     * @param itrbl Iterable of UUID
     * @return list of entity type
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Override
    @Query("select e from #{#entityName} e where e.uuid in ?1 and e.deleted = 0")
    public List<T> findAllById(Iterable<UUID> itrbl);

    /**
     * retrieve undeleted by Sort
     *
     * @param sort Sorting data
     * @return list of entity type
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Override
    @Query("from #{#entityName} e where e.deleted=0")
    public List<T> findAll(Sort sort);

    /**
     * retrieve entity by id
     *
     * @param id the id of entity
     * @return entity entity type
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Override
    @Query("from #{#entityName} e where  e.uuid=?1 and e.deleted=0")
    public T getOne(UUID id);

    /**
     * update entity
     *
     * @param entity Entity type
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    default public void update(T entity) {
        save(entity);
    }

}
