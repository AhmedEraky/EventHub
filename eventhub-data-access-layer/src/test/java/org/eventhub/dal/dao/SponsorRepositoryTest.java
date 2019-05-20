package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.*;
import org.eventhub.dal.config.Config;
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
 * Test Class for {@link org.eventhub.dal.dao.SponsorRepository}
 *
 * @author Mohamed Gamal <mohamedj239@gmail.com>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SponsorRepositoryTest implements BaseRepositoryTest {

    @Autowired
    SponsorRepository sponsorRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    SponsorshipTypeRepository sponsorshipTypeRepository;

    Pageable pageable = PageRequest.of(0, 5);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testCount() {
        long bSize = sponsorRepository.count();
        saveSponsor();
        long aSize = sponsorRepository.count();

        assertEquals(bSize + 1, aSize);

    }

    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testDelete() {
        Sponsor bSponsor = saveSponsor();

        Sponsor aSponsor = sponsorRepository.getOne(bSponsor.getUuid());
        assertEquals(bSponsor.getName(), aSponsor.getName());

        long bCount = sponsorRepository.count();
        sponsorRepository.delete(bSponsor);
        long aCount = sponsorRepository.count();

        assertNull(sponsorRepository.getOne(bSponsor.getUuid()));
        assertEquals(aCount, bCount);
    }

    /**
     * test deleteById Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testDeleteByID() {
        Sponsor bSponsor = saveSponsor();

        Sponsor aSponsor = sponsorRepository.getOne(bSponsor.getUuid());
        assertEquals(bSponsor.getName(), aSponsor.getName());

        UUID id = bSponsor.getUuid();
        Long count = sponsorRepository.count();
        sponsorRepository.deleteById(id);
        assertNull("Object Should not Exist", sponsorRepository.getOne(id));
        assertEquals(count, (Long) sponsorRepository.count());
    }

    /**
     * test softDelete Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testSoftDelete() {
        Sponsor bSponsor = saveSponsor();

        Sponsor aSponsor = sponsorRepository.getOne(bSponsor.getUuid());
        assertEquals(bSponsor.getName(), aSponsor.getName());

        UUID id = bSponsor.getUuid();
        Long count = sponsorRepository.count();
        sponsorRepository.deleteById(id);
        assertNull("Object Should not Exist", sponsorRepository.getOne(id));
        assertEquals(count, (Long) sponsorRepository.count());
    }

    /**
     * test findByName Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testFindByName() {
        Sponsor bSponsor = saveSponsor();

        Sponsor aSponsor = sponsorRepository.findByName("dummySponsor");
        assertEquals(bSponsor.getName(), aSponsor.getName());
    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testSave() {
        Sponsor bSponsor = saveSponsor();

        Sponsor aSponsor = sponsorRepository.findById(bSponsor.getUuid()).get();
        assertEquals(bSponsor.getName(), aSponsor.getName());

    }

    /**
     * test findAllDeleted Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testFindAllDeleted() {
        long bSize = sponsorRepository.findAllDeleted(pageable).size();
        Sponsor bSponsor = saveSponsor();

        sponsorRepository.delete(bSponsor);
        long aSize = sponsorRepository.findAllDeleted(pageable).size();

        assertEquals(bSize+1,aSize);

    }

    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testFindAll() {
        long bSize = sponsorRepository.findAll().size();
        Sponsor bSponsor = saveSponsor();

        long aSize = sponsorRepository.findAll().size();
        assertEquals(bSize+1,aSize);

    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.SponsorRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Override
    @Test
    public void testUpdate() {
        Sponsor bSponsor = saveSponsor();

        bSponsor.setName("updatedDummySponsor");
        sponsorRepository.update(bSponsor);

        Sponsor aUpdateSponsor = sponsorRepository.findById(bSponsor.getUuid()).get();
        assertEquals(bSponsor.getName(),aUpdateSponsor.getName());

    }

    private Sponsor saveSponsor() {
        Sponsor bSponsor = new Sponsor(null, "dummySponsor");
        Event event = new Event(null, "dummyEvent", "dummyShortDescription", "dummyAddress", new Date(), new Date(), "dummyStyle");
        Organization organization = new Organization(null, "dummyOrganization");
        SystemUser systemUser = new SystemUser(null, "dummyUserName", "dummy", "dummy", "dummy@dm.com");
        SponsorshipType sponsorshipType = new SponsorshipType(null, "dummySponsorType");

        organizationRepository.save(organization);
        systemUserRepository.save(systemUser);
        sponsorshipTypeRepository.save(sponsorshipType);

        event.setOrganization(organization);
        event.setSystemUser(systemUser);

        eventRepository.save(event);
        bSponsor.setEvent(event);
        bSponsor.setSponsorshipType(sponsorshipType);
        sponsorRepository.save(bSponsor);

        return bSponsor;
    }
}
