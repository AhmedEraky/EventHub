package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.SponsorshipType;
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

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Class for {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
 *
 * @author Mohamed Gamal <mohamedj239@gmail.com>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SponsorshipTypeRepositoryTest implements BaseRepositoryTest{

    @Autowired
    SponsorshipTypeRepository sponsorshipTypeRepository;

    Pageable pageable = PageRequest.of(0, 5);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testCount() {
        long bSize = sponsorshipTypeRepository.count();
        SponsorshipType sponsorshipType = new SponsorshipType(null, "dummyType");
        sponsorshipTypeRepository.save(sponsorshipType);

        long aSize = sponsorshipTypeRepository.count();
        assertEquals(bSize+1,aSize);

    }

    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testDelete() {
        SponsorshipType bSponsorshipType = new SponsorshipType(null, "dummyType");
        sponsorshipTypeRepository.save(bSponsorshipType);

        SponsorshipType aSponsorshipType1 = sponsorshipTypeRepository.getOne(bSponsorshipType.getUuid());
        assertEquals(bSponsorshipType.getName(),aSponsorshipType1.getName());

        long bCount = sponsorshipTypeRepository.count();
        sponsorshipTypeRepository.delete(bSponsorshipType);
        long aCount = sponsorshipTypeRepository.count();

        assertNull("The Object Should not Exist",sponsorshipTypeRepository.getOne(bSponsorshipType.getUuid()));
        assertEquals(bCount,aCount);
    }

    /**
     * test deleteById Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testDeleteByID() {
        SponsorshipType bSponsorshipType = new SponsorshipType(null, "dummyType");
        sponsorshipTypeRepository.save(bSponsorshipType);

        SponsorshipType aSponsorshipType1 = sponsorshipTypeRepository.getOne(bSponsorshipType.getUuid());
        assertEquals(bSponsorshipType.getName(),aSponsorshipType1.getName());

        UUID id = bSponsorshipType.getUuid();
        long bCount = sponsorshipTypeRepository.count();
        sponsorshipTypeRepository.deleteById(id);
        long aCount = sponsorshipTypeRepository.count();

        assertNull("The Object Should not Exist",sponsorshipTypeRepository.getOne(id));
        assertEquals(bCount,aCount);
    }

    /**
     * test softDelete Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testSoftDelete() {
        SponsorshipType bSponsorshipType = new SponsorshipType(null, "dummyType");
        sponsorshipTypeRepository.save(bSponsorshipType);

        SponsorshipType aSponsorshipType1 = sponsorshipTypeRepository.getOne(bSponsorshipType.getUuid());
        assertEquals(bSponsorshipType.getName(),aSponsorshipType1.getName());

        UUID id = bSponsorshipType.getUuid();
        long bCount = sponsorshipTypeRepository.count();
        sponsorshipTypeRepository.softDelete(id);
        long aCount = sponsorshipTypeRepository.count();

        assertNull("The Object Should not Exist",sponsorshipTypeRepository.getOne(id));
        assertEquals(bCount,aCount);
    }

    /**
     * test findByName Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testFindByName() {
        SponsorshipType bSponsorshipType = new SponsorshipType(null,"dummyType");
        sponsorshipTypeRepository.save(bSponsorshipType);

        SponsorshipType aSponsorshipType = sponsorshipTypeRepository.findByName("dummyType");
        assertEquals(bSponsorshipType.getName(),aSponsorshipType.getName());
    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testSave() {
        SponsorshipType bSponsorshipType = new SponsorshipType(null, "dummyType");
        long bCount = sponsorshipTypeRepository.count();
        sponsorshipTypeRepository.save(bSponsorshipType);
        long aCount = sponsorshipTypeRepository.count();
        SponsorshipType aSponsorshipType = sponsorshipTypeRepository.findById(bSponsorshipType.getUuid()).get();
        assertEquals(bSponsorshipType.getName(),aSponsorshipType.getName());
        assertEquals(bCount+1,aCount);
    }

    /**
     * test findAllDeleted Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        long bSize = sponsorshipTypeRepository.findAllDeleted(pageable).size();
        SponsorshipType bSponsorshipType = new SponsorshipType(null, "dummyType");
        sponsorshipTypeRepository.save(bSponsorshipType);

        sponsorshipTypeRepository.delete(bSponsorshipType);
        long aSize = sponsorshipTypeRepository.findAllDeleted(pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testFindAll() {
        long bSize= sponsorshipTypeRepository.findAll().size();
        SponsorshipType bSponsorshipType = new SponsorshipType(null, "dummyType");
        sponsorshipTypeRepository.save(bSponsorshipType);

        long aSize  = sponsorshipTypeRepository.findAll().size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.SponsorshipTypeRepository}
     *
     * @author Mohamed Gamal <mohamedj239@gmail.com>
     */
    @Test
    @Override
    public void testUpdate() {
        SponsorshipType bSponsorshipType = new SponsorshipType(null, "dummyType");
        sponsorshipTypeRepository.save(bSponsorshipType);

        bSponsorshipType.setName("updatedDummyType");
        sponsorshipTypeRepository.update(bSponsorshipType);

        SponsorshipType aSponsorshipType = sponsorshipTypeRepository.findById(bSponsorshipType.getUuid()).get();
        assertEquals(bSponsorshipType.getName(),aSponsorshipType.getName());
    }
}
