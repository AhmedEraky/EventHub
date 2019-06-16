package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.SessionInHall;
import org.eventhub.remote.dto.SessionInHallDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionInHallAdapter implements DtoAdapter<SessionInHall, SessionInHallDTO>
{
    @Autowired
    HallAdapter hallAdapter;

    @Autowired
    SessionAdapter sessionAdapter;

    @Override
    public SessionInHall fromDto(SessionInHallDTO sessionInHallDTO)
    {
        SessionInHall sessionInHall = new SessionInHall();
        sessionInHall.setUuid(sessionInHallDTO.getUuid());
        sessionInHall.setHall(hallAdapter.fromDto(sessionInHallDTO.getHall()));
        sessionInHall.setSession(sessionAdapter.fromDto(sessionInHallDTO.getSession()));
        sessionInHall.setOrderNumber(sessionInHallDTO.getOrderNumber());
        return sessionInHall;
    }

    @Override
    public SessionInHallDTO toDto(SessionInHall sessionInHall)
    {
        SessionInHallDTO sessionInHallDTO = new SessionInHallDTO();
        sessionInHallDTO.setUuid(sessionInHall.getUuid());
        sessionInHallDTO.setHall(hallAdapter.toDto(sessionInHall.getHall()));
        sessionInHallDTO.setSession(sessionAdapter.toDto(sessionInHall.getSession()));
        sessionInHallDTO.setOrderNumber(sessionInHall.getOrderNumber());
        return sessionInHallDTO;
    }
}
