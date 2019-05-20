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
     *  soft delete an object
     * @param uuid the id of the entity
     * @author Aya Taha
     */
    @Query("update #{#entityName} e set e.deleted=true where e.uuid=?1")
    @Modifying
    @Transactional
    public void softDelete(UUID uuid);

    /**
     *  soft delete an object
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Query("update #{#entityName} e set e.deleted=true where e=?1")
    @Modifying
    @Override
    void delete(T t);

    /**
     *  soft delete an object by ID
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Query("update #{#entityName} e set e.deleted=true where e.uuid=?1")
    @Modifying
    @Transactional
    @Override
    void deleteById(UUID uuid);

    /**
     *  retrieve the existing entities
     * @return list of entity
     * @author Aya Taha
     */
    @Query("from #{#entityName} e where e.deleted=0")
    public Page<T> findAll(Pageable pageable);



    /**
     *  retrieve deleted entities
     * @return list of deleted entities
     * @author Aya Taha
     */
    @Query("from #{#entityName} e where e.deleted=1")
    public List<T> findAllDeleted(Pageable pageable);

    @Override
    @Query("from #{#entityName} e where e.deleted=0")
    public <S extends T> List<S> findAll(Example<S> exmpl, Sort sort);

    @Override
    @Query("from #{#entityName} e where e.deleted=0")
    public <S extends T> Page<S> findAll(Example<S> exmpl, Pageable pageable);

    @Override
    @Query("select e from #{#entityName} e where e.uuid in ?1 and e.deleted = 0")
    public List<T> findAllById(Iterable<UUID> itrbl);

    @Override
    @Query("from #{#entityName} e where e.deleted=0")
    public List<T> findAll(Sort sort);



    @Override
    @Query("from #{#entityName} e where  e.uuid=?1 and e.deleted=0")
    public T getOne(UUID id);


}
