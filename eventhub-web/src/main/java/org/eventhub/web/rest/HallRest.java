package org.eventhub.web.rest;

import org.eventhub.common.model.entity.Hall;
import org.eventhub.facade.hall.HallManagementFacade;
import org.eventhub.facade.hall.HallRetrivalFacade;
import org.eventhub.remote.adapter.HallAdapter;
import org.eventhub.remote.dto.HallDTO;
import org.eventhub.remote.dto.JResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * RestController for Hall entity
 *
 * @author Islam El-Rougy
 */
@RestController
public class HallRest
{
    @Autowired
    HallAdapter hallAdapter;

    @Autowired
    HallRetrivalFacade hallRetrivalFacade;

    @Autowired
    HallManagementFacade hallManagementFacade;

    /**
     * get Hall by uuid
     *
     * @param uuid the id of the required Hall
     * @return {@link JResponse} Json response that wraps the required Hall
     * @author Islam El-Rougy (islamelrougy@gmail.com)
     */
    @GetMapping(value = "/retrieveHall", params = "id")
    public JResponse retrieveHallById(@RequestParam("id") UUID uuid)
    {
        Hall hall = hallRetrivalFacade.getHallById(uuid);
        JResponse hallRetrievalResponse = new JResponse();
        hallRetrievalResponse.setDtoContent(hallAdapter.toDto(hall));
        return hallRetrievalResponse;
    }

    /**
     * persist a new Hall in the database
     *
     * @param hallDTO the Dto of the persisted Hall
     * @return {@link JResponse} Json response that wraps the persistent Hall
     * @author Islam El-Rougy (islamelrougy@gmail.com)
     */
    @PostMapping(value = "/persistHall")
    public JResponse persistHall(@RequestBody HallDTO hallDTO)
    {
        Hall hall = hallAdapter.fromDto(hallDTO);
        Hall persistentHall = hallManagementFacade.creatHall(hall);
        JResponse hallResponse = new JResponse();
        hallResponse.setDtoContent(hallAdapter.toDto(persistentHall));
        hallResponse.setStatus("success");
        return hallResponse;
    }

    /**
     * update a specific Hall
     *
     * @param hallDTO the Dto of the Hall to be updated
     * @return {@link JResponse} Json response that wraps the updated Hall entity
     * @author Islam El-Rougy (islamelrougy@gmail.com)
     */
    @PutMapping(value = "/updateHall")
    public JResponse updateHall(@RequestBody  HallDTO hallDTO)
    {
        Hall hall = hallAdapter.fromDto(hallDTO);
        hallManagementFacade.updateHall(hall);
        JResponse hallResponse = new JResponse();
        hallResponse.setDtoContent(hallAdapter.toDto(hall));
        return hallResponse;
    }

}
