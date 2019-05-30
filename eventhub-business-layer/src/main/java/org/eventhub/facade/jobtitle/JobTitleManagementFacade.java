/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.jobtitle;

import org.eventhub.common.model.entity.JobTitle;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
public interface JobTitleManagementFacade {

    public void creatJobTitle(JobTitle jobTitle);

    public void updateJobTitle(JobTitle jobTitle);

}
