/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.coordinator;

import org.eventhub.common.model.entity.EventCoordinator;

/**
 *
 * @author pc
 */
public interface CoordinatorManagmentFacat {
    public void addEventCoordinator(EventCoordinator eventCoordinator);
}
