/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.jobtitle.impl;

import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.facade.jobtitle.JobTitleManagementFacade;
import org.eventhub.service.jobtitle.JobTitleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Component
public class JobTitleManagementFacadeImpl implements JobTitleManagementFacade {

    @Autowired
    JobTitleManagementService jobTitleManagementService;

    @Override
    public void creatJobTitle(JobTitle jobTitle) {
        jobTitleManagementService.creatJobTitle(jobTitle);
    }

    @Override
    public void updateJobTitle(JobTitle jobTitle) {
        jobTitleManagementService.updateJobTitle(jobTitle);
    }

}
