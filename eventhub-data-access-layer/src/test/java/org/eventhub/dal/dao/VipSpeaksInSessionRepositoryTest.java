package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.*;
import org.eventhub.dal.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Class for {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
 *
 * @author Mohamed Gamal (mohamedj239@gmail.com)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class VipSpeaksInSessionRepositoryTest implements BaseRepositoryTest {

    @Autowired
    VipSpeaksInSessionRepository vipSpeaksInSessionRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    SessionTypeRepository sessionTypeRepository;

    @Autowired
    VipRepository vipRepository;

    @Autowired
    JobTitleRepository jobTitleRepository;

    Pageable pageable = PageRequest.of(0, 5);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testCount() {
        long bSize = vipSpeaksInSessionRepository.count();
        saveVipSpeaksInSession();

        long aSize = vipSpeaksInSessionRepository.count();
        assertEquals(bSize + 1, aSize);

    }

    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testDelete() {
        VipSpeaksInSession bVipSpeaksInSession = saveVipSpeaksInSession();

        VipSpeaksInSession aVipSpeaksInSession = vipSpeaksInSessionRepository.getOne(bVipSpeaksInSession.getUuid());
        assertEquals(bVipSpeaksInSession.getUuid(),aVipSpeaksInSession.getUuid());

        long bCount = vipSpeaksInSessionRepository.count();
        vipSpeaksInSessionRepository.delete(bVipSpeaksInSession);
        long aCount = vipSpeaksInSessionRepository.count();

        assertNull("Object Should Not Exist",vipSpeaksInSessionRepository.getOne(bVipSpeaksInSession.getUuid()));
        assertEquals(aCount,bCount);
    }

    /**
     * test deleteById Method
     * {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testDeleteByID() {
        VipSpeaksInSession bVipSpeaksInSession = saveVipSpeaksInSession();

        VipSpeaksInSession aVipSpeaksInSession = vipSpeaksInSessionRepository.getOne(bVipSpeaksInSession.getUuid());
        assertEquals(bVipSpeaksInSession.getUuid(),aVipSpeaksInSession.getUuid());

        UUID id = bVipSpeaksInSession.getUuid();
        long bCount = vipSpeaksInSessionRepository.count();
        vipSpeaksInSessionRepository.deleteById(id);
        long aCount = vipSpeaksInSessionRepository.count();

        assertNull("Object Should not Exist",vipSpeaksInSessionRepository.getOne(id));
        assertEquals(bCount,aCount);
    }

    /**
     * test softDelete Method
     * {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testSoftDelete() {
        VipSpeaksInSession bVipSpeaksInSession = saveVipSpeaksInSession();

        VipSpeaksInSession aVipSpeaksInSession = vipSpeaksInSessionRepository.getOne(bVipSpeaksInSession.getUuid());
        assertEquals(bVipSpeaksInSession.getUuid(),aVipSpeaksInSession.getUuid());

        UUID id = bVipSpeaksInSession.getUuid();
        long bCount = vipSpeaksInSessionRepository.count();
        vipSpeaksInSessionRepository.softDelete(id);
        long aCount = vipSpeaksInSessionRepository.count();

        assertNull("Object Should not Exist",vipSpeaksInSessionRepository.getOne(id));
        assertEquals(bCount,aCount);
    }


    /**
     * test save Method
     * {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testSave() {
        VipSpeaksInSession bVipSpeaksInSession = saveVipSpeaksInSession();

        VipSpeaksInSession aVipSpeaksInSession = vipSpeaksInSessionRepository.findById(bVipSpeaksInSession.getUuid()).get();
        assertEquals(bVipSpeaksInSession.getUuid(),aVipSpeaksInSession.getUuid());

    }

    /**
     * test findAllDeleted Method
     * {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        long bSize = vipSpeaksInSessionRepository.findAllDeleted(pageable).size();
        VipSpeaksInSession bVipSpeaksInSession = saveVipSpeaksInSession();

        vipSpeaksInSessionRepository.delete(bVipSpeaksInSession);
        long aSize = vipSpeaksInSessionRepository.findAllDeleted(pageable).size();

        assertEquals(bSize+1,aSize);
    }

    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testFindAll() {
        long bSize = vipSpeaksInSessionRepository.findAll().size();
        saveVipSpeaksInSession();

        long aSize = vipSpeaksInSessionRepository.findAll().size();
        assertEquals(bSize+1,aSize);

    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.VipSpeaksInSessionRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testUpdate() {
        VipSpeaksInSession bVipSpeaksInSession = saveVipSpeaksInSession();

        bVipSpeaksInSession.getSession().setName("updateDummySessionName");
        vipSpeaksInSessionRepository.update(bVipSpeaksInSession);

        VipSpeaksInSession aVipSpeaksInSession = vipSpeaksInSessionRepository.findById(bVipSpeaksInSession.getUuid()).get();
        assertEquals(bVipSpeaksInSession.getSession().getName(),aVipSpeaksInSession.getSession().getName());
    }

    private VipSpeaksInSession saveVipSpeaksInSession(){
        VipSpeaksInSession vipSpeaksInSession = new VipSpeaksInSession();
        Session session = new Session(null, new Date(), new Date(), "dummySession", "dummyDesc", 100);
        SessionType sessionType = new SessionType(null, "dummySessionType", "dummyStyle");
        Event event = new Event(null, "dummyEvent", "dummyDesc", "dummyAddress", new Date(), new Date(), "dummyStyle");
        Organization organization = new Organization(null, "dummyOrganization");
        SystemUser systemUser = new SystemUser(null, "dummyUserName", "dummy", "dummy", "dummy@dm.com",UserGender.Female);
        Vip vip = new Vip(null, "dummyBio", "dummyName");
        JobTitle jobTitle = new JobTitle(null, "dummyJobTitle");

        organizationRepository.save(organization);
        systemUserRepository.save(systemUser);
        event.setSystemUser(systemUser);
        event.setOrganization(organization);
        eventRepository.save(event);

        sessionTypeRepository.save(sessionType);
        session.setEvent(event);
        session.setSessionType(sessionType);
        sessionRepository.save(session);

        jobTitleRepository.save(jobTitle);
        vip.setJobTitle(jobTitle);
        vip.setOrganization(organization);
        vipRepository.save(vip);

        vipSpeaksInSession.setSession(session);
        vipSpeaksInSession.setVip(vip);
        vipSpeaksInSessionRepository.save(vipSpeaksInSession);

        return vipSpeaksInSession;
    }
}
