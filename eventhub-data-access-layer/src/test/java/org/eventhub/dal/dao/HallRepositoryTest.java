/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.Hall;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.Session;
import org.eventhub.common.model.entity.SessionInHall;
import org.eventhub.common.model.entity.SessionType;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.config.Config;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test Class for {@link org.eventhub.dal.dao.EventCoordinatorRepository}
 *
 * @author Aya Taha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class HallRepositoryTest implements BaseRepositoryTest{

    @Autowired
    EventRepository eventRepository;
    @Autowired
    HallRepository hallRepository;
    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    SessionInHallRepository sessionInHallRepository;
    @Autowired
    SessionTypeRepository sessionTypeRepository;


    /**
     * test count Method {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testCount() {
        long bCount = hallRepository.count();
        Hall hall = insertHall();
        hallRepository.save(hall);
        long aCount = hallRepository.count();
        assertEquals(bCount + 1, aCount);
    }

    /**
     * test  Method delete
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testDelete() {
        Hall hall = insertHall();
        hallRepository.save(hall);
        Hall hall1 = hallRepository.getOne(hall.getUuid());
        assertEquals(hall.getEvent().getName(), hall1.getEvent().getName());
        Long count = hallRepository.count();
        hallRepository.delete(hall);
        assertNull(hallRepository.getOne(hall.getUuid()));
        assertEquals(count, (Long) hallRepository.count());
    }

    
    /**
     * test save Method {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testSave() {
        Hall hall = insertHall();
        hallRepository.save(hall);
        Hall hall1 = hallRepository.findById(hall.getUuid()).get();
        assertEquals(hall1.getEvent().getName(), hall.getEvent().getName());
    }

    /**
     * test  Method update
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testUpdate() {
        Pageable pageable = PageRequest.of(0, 555555);
        Hall hall = insertHall();
        hallRepository.save(hall);
        Hall hall1 = hallRepository.findById(hall.getUuid()).get();
        //add new event
        List<SystemUser> systemUsers = systemUserRepository.findAllByFirstName("firstName", pageable);
        Organization organization = new Organization(null, "orgn");
        organizationRepository.save(organization);
        Event eventn = new Event(null, "name2", "shortDescription", "address", new Date(), new Date(), "style");
        eventn.setOrganization(organization);
        eventn.setSystemUser(systemUsers.get(0));
        eventRepository.save(eventn);
        //update
        List<Event> events = eventRepository.findAllByName("name2", pageable);
        hall1.setEvent(events.get(0));
        hallRepository.update(hall1);
        Hall hall2 = hallRepository.getOne(hall.getUuid());
        System.out.println(hall2.getEvent().getName());
        assertEquals(hall1.getEvent().getName(), hall2.getEvent().getName());

    }
    
    /**
     * test findAll Deleted Method
     * {@link org.eventhub.dal.dao.HallRepository}
     * @author Aya Taha
     */
    
    
    @Test
    @Override
    public void testFindAllDeleted(){
        Pageable pageable = PageRequest.of(0, 555555);
        int bCount=hallRepository.findAllDeleted(pageable).size();
        Hall hall = insertHall();
        hallRepository.save(hall);
        hallRepository.delete(hall);
        assertEquals(bCount+1,hallRepository.findAllDeleted(pageable).size());
    }
    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.HallRepository}
     * @author Aya Taha
     */
    @Override
    @Test
    public void testFindAll(){
       
        int bCount=hallRepository.findAll().size();
        Hall hall = insertHall();
        hallRepository.save(hall);
        int aCount=hallRepository.findAll().size();
        assertEquals(bCount+1,aCount);
    }

    
     /**
     * test SoftDelete Method
     * {@link org.eventhub.dal.dao.HallRepository}
     * @author Aya Taha
     */
    
    @Test
    @Override
    public void testSoftDelete() {
         Hall hall = insertHall();
        hallRepository.save(hall);
        Hall hall1=hallRepository.getOne(hall.getUuid());
        assertEquals(hall.getEvent().getName(),hall1.getEvent().getName());
        UUID id=hall.getUuid();
        System.out.println(hallRepository.count());
        hallRepository.softDelete(id);
        System.out.println(hallRepository.count());
        assertNull(hallRepository.getOne(id));
    }
    /**
     * test  Method deleteByID
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testDeleteByID() {

         Hall hall = insertHall();
        hallRepository.save(hall);
        Hall hall1 = hallRepository.getOne(hall.getUuid());
        assertEquals(hall.getEvent().getName(), hall1.getEvent().getName());
        assertEquals(hall.getEvent().getName(), hall1.getEvent().getName());
        UUID id = hall.getUuid();
        Long count = hallRepository.count();
        hallRepository.deleteById(id);
        assertNull(hallRepository.getOne(id));
        assertEquals(count, (Long) hallRepository.count());

    }

    @Override
    public void testFindByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
     /**
     * test  Method findAllByFloor
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByFloor(){
         Pageable pageable = PageRequest.of(0, 555555);
        Hall hall = insertHall();
        hall.setFloor("floor");
        hallRepository.save(hall);
        List<Hall> halls= hallRepository.findAllByFloor("floor", pageable);
         assertEquals(hall.getFloor(), halls.get(0).getFloor());
    }
    
    /**
     * test  Method findAllByBuilding
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByBuilding(){
         Pageable pageable = PageRequest.of(0, 555555);
        Hall hall = insertHall();
        hall.setBuilding("building");
        hallRepository.save(hall);
        List<Hall> halls= hallRepository.findAllByBuilding("building", pageable);
         assertEquals(hall.getBuilding(), halls.get(0).getBuilding());
    }
    
      /**
     * test  Method findAllByName
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByName(){
         Pageable pageable = PageRequest.of(0, 555555);
        Hall hall = insertHall();
        hallRepository.save(hall);
        List<Hall> halls= hallRepository.findAllByName("mainHall", pageable);
         assertEquals(hall.getName(), halls.get(0).getName());
    }
    
    
   
      /**
     * test  Method  findAllByCapacity
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByCapacity(){
         Pageable pageable = PageRequest.of(0, 555555);
        Hall hall = insertHall();
        hall.setCapacity(34);
        hallRepository.save(hall);
        List<Hall> halls= hallRepository.findAllByCapacity(34, pageable);
         assertEquals(hall.getCapacity(), halls.get(0).getCapacity());
    }
    
     /**
     * test findAllByEvent Method
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByEvent() {
        Pageable pageable = PageRequest.of(0, 555555);
        Hall hall = insertHall();
        hallRepository.save(hall);
        List<Event> events = eventRepository.findAllByName("name", pageable);
        List<Hall> halls = hallRepository.findAllByEvent(events.get(0), pageable);
        assertEquals(halls.get(0).getEvent().getName(), hall.getEvent().getName());

    }
    
     /**
     * test findAllBySessionInHalls Method
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllBySessionInHalls() {
        Pageable pageable = PageRequest.of(0, 555555);
        Hall hall = insertHall();
        //sessionInhall
        SessionInHall sessionInHall=new SessionInHall(null,1);
        Session session=new Session(null, new Date(), new Date(), "name", "desc", 5);
        List<Event> events = eventRepository.findAllByName("name", pageable);
        session.setEvent(events.get(0));
        SessionType sessionType=new SessionType(null, "type", "style");
        sessionTypeRepository.save(sessionType);
        session.setSessionType(sessionType);
         sessionRepository.save(session);
        sessionInHall.setSession(session);
        hallRepository.save(hall);
        sessionInHall.setHall(hall);
        sessionInHallRepository.save(sessionInHall);
     List<Hall> halls = hallRepository.findAllBySessionInHalls(sessionInHall, pageable);
        assertEquals(halls.get(0), sessionInHall.getHall());

    }
    
    
    
    private Hall insertHall() {
        SystemUser systemUser = new SystemUser(null, "username", "firstName", "password", "email");
        systemUserRepository.save(systemUser);
        Organization organization = new Organization(null, "org");
        organizationRepository.save(organization);
        Event event = new Event(null, "name", "shortDescription", "address", new Date(), new Date(), "style");
        event.setOrganization(organization);
        event.setSystemUser(systemUser);
        eventRepository.save(event);
        Hall hall = new Hall(null, "mainHall");
        hall.setEvent(event);
        return hall;
    }
}
