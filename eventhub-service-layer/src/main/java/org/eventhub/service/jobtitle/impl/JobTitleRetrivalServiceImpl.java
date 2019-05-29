/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.jobtitle.impl;

import java.util.UUID;
import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.dal.dao.JobTitleRepository;
import org.eventhub.service.jobtitle.JobTitleRetrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Service
public class JobTitleRetrivalServiceImpl implements JobTitleRetrivalService {

    @Autowired
    JobTitleRepository jobTitleRepository;

    @Override
    public JobTitle getJobTitleById(UUID uuid) {
        return jobTitleRepository.findById(uuid).get();
    }

}
