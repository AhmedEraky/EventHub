/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.session;

import java.util.UUID;
import org.eventhub.common.model.entity.Session;

/**
 *
 * @author Aly
 */
public interface SessionRetrievalService {
    public Session getSessionById(UUID uuid);
}
