/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.hall;

import org.eventhub.common.model.entity.Hall;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
public interface HallManagementFacade {

    public Hall creatHall(Hall hall);

    public void updateHall(Hall hall);

}
