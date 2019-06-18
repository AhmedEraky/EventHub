/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Session;
import org.eventhub.facade.session.SessionManagementFacade;
import org.eventhub.facade.session.SessionRetrievalFacade;
import org.eventhub.web.rest.remote.adapter.SessionAdapter;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.eventhub.web.rest.remote.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    SessionRetrievalFacade sessionRetrievalFacade;
    @Autowired
    SessionManagementFacade sessionManagementFacade;
    @Autowired
    SessionAdapter sessionAdapter;

    /**
     * get all sessions
     *
     * @author Amr Elkady (amrelkady93@gmail.com)
     * @return JResponse the sessionResponse to client
     */
    @GetMapping("/allsession")
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

    /**
     * get session based on ID
     *
     * @author Amr Elkady (amrelkady93@gmail.com)
     * @return JResponse the sessionResponse to client
     */
    @GetMapping("/session/{id}")
    public JResponse<SessionDTO> getSessionById(@PathVariable("id") UUID uuid) {
        Session vip = sessionRetrievalFacade.getSessionById(uuid);
        JResponse jResponse = new JResponse();

        try {
            jResponse.setDtoContent(sessionAdapter.toSessionDTO(vip));
            jResponse.setStatus("success");
        } catch (Exception e) {
            jResponse.setStatus("Fail");
            jResponse.setDtoContent(new SessionDTO());
        }

        return jResponse;

    }

    //menna
    //husseny
    /**
     * Responsible for creating new session
     *
     * @author Elhosany <mohamed.elhosany1995@gmail.com>
     * @param sessionDTO the sessionDTO that represent the session
     * @return the sessionResponse to client
     */
    @PostMapping("/addSession")
    public JResponse<SessionDTO> addSession(@RequestBody SessionDTO sessionDTO) {
        JResponse<SessionDTO> sessionResponse = new JResponse<>();
        Session session = sessionAdapter.fromSessionDTO(sessionDTO);
        try {
            sessionManagementFacade.createSession(session);
            sessionResponse.setDtoContent(sessionDTO);
            sessionResponse.setStatus("Success");
        } catch (Exception e) {
            sessionResponse.setStatus("Fail");
            sessionResponse.setDtoContent(new SessionDTO());
        }

        return sessionResponse;
    }

}
