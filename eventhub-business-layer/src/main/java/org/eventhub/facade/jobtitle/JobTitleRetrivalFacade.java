/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.jobtitle;

import java.util.UUID;
import org.eventhub.common.model.entity.JobTitle;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
public interface JobTitleRetrivalFacade {

    public JobTitle getJobTitleById(UUID uuid);

}
