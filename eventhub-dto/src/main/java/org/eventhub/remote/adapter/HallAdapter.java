package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.Hall;
import org.eventhub.common.model.entity.Session;
import org.eventhub.common.model.entity.SessionInHall;
import org.eventhub.remote.dto.HallDTO;
import org.eventhub.remote.dto.SessionInHallDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HallAdapter implements DtoAdapter<Hall, HallDTO>
{
    @Autowired
    EventAdapter eventAdapter;

    @Autowired
    SessionInHallAdapter sessionAdapter;

    @Override
    public Hall fromDto(HallDTO hallDTO)
    {
        Hall hall = new Hall();
        hall.setUuid(hallDTO.getUuid());
        hall.setName(hallDTO.getName());
        hall.setCapacity(hallDTO.getCapacity());
        hall.setFloor(hallDTO.getFloor());
        hall.setBuilding(hallDTO.getBuilding());
        hall.setEvent(eventAdapter.fromDto(hallDTO.getEvent()));
        /*List<SessionInHall> sessionsInHall = new ArrayList<>();
        hallDTO.getSessionInHallDTOs().forEach(sessionInHallDTO -> sessionsInHall.add(sessionAdapter.fromDto(sessionInHallDTO)));
        hall.setSessionInHalls(sessionsInHall);*/
        return hall;
    }

    @Override
    public HallDTO toDto(Hall hall)
    {
        HallDTO hallDTO = new HallDTO();
        hallDTO.setUuid(hall.getUuid());
        hallDTO.setName(hall.getName());
        hallDTO.setCapacity(hall.getCapacity());
        hallDTO.setFloor(hall.getFloor());
        hallDTO.setBuilding(hall.getBuilding());
        hallDTO.setEvent(eventAdapter.toDto(hall.getEvent()));
        /*List<SessionInHallDTO> sessionInHallDTOs = new ArrayList<>();
        hall.getSessionInHalls().forEach(sessionInHall -> sessionInHallDTOs.add(sessionAdapter.toDto(sessionInHall)));
        hallDTO.setSessionInHallDTOs(sessionInHallDTOs);*/
        return hallDTO;
    }
}
