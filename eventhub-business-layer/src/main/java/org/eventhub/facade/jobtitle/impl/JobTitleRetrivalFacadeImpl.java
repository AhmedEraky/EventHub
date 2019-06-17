/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.jobtitle.impl;

import java.util.UUID;
import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.facade.jobtitle.JobTitleRetrivalFacade;
import org.eventhub.service.jobtitle.JobTitleRetrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Component
public class JobTitleRetrivalFacadeImpl implements JobTitleRetrivalFacade{

    @Autowired
    JobTitleRetrivalService jobTitleRetrivalService;
    @Override
    public JobTitle getJobTitleById(UUID uuid) {
        return jobTitleRetrivalService.getJobTitleById(uuid);
    }
    
}
