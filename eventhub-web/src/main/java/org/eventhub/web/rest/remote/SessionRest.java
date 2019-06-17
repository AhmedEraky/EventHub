/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote;

import java.util.ArrayList;
import java.util.List;
import org.eventhub.common.model.entity.Session;
import org.eventhub.facade.session.SessionRetrievalFacade;
import org.eventhub.web.rest.remote.adapter.SessionAdapter;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.eventhub.web.rest.remote.dto.SessionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@RestController
@RequestMapping("/api")
public class SessionRest {

    //Amr
    SessionRetrievalFacade sessionRetrievalFacade;

    SessionAdapter sessionAdapter;

    @GetMapping("/sessions")
    public JResponse<List> getAllSessions() {
        List<Session> sessions = sessionRetrievalFacade.getAllSession();
        List<SessionDTO> sessionDTO = new ArrayList();
        JResponse<List> jResponse = new JResponse<>();
        try {
            for (Session session : sessions) {
                sessionDTO.add(sessionAdapter.toSessionDTO(session));
            }
            jResponse.setDtoContent(sessionDTO);
            jResponse.setStatus("Success");
        } catch (Exception e) {
            jResponse.setStatus("Fail");
            jResponse.setDtoContent(new ArrayList<>());
        }

        return jResponse;
    }

    //menna
    //husseny
}
