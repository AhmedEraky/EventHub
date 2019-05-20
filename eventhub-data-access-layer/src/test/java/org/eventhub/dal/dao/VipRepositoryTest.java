package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.Vip;
import org.eventhub.dal.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class VipRepositoryTest {

    @Autowired
    VipRepository vipRepository;
    @Autowired
    JobTitleRepository jobTitleRepository;
    @Autowired
    OrganizationRepository organizationRepository;



    @Test
    public void testSave(){
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        vipRepository.save(bvip);
        Vip aVip=vipRepository.getOne(bvip.getUuid());
        assertEquals(bvip.getUuid(),aVip.getUuid());

    }
}
