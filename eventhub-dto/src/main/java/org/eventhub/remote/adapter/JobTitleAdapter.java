/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.remote.dto.JobTitleDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author FARES-LAP
 */
@Component
public class JobTitleAdapter {

    public JobTitleDTO toJobTitleDTO(JobTitle jobTitle) {
        return null;
    }

    JobTitle fromJobTitleDTO(JobTitle jobTitle) {
        return null;
    }
}
