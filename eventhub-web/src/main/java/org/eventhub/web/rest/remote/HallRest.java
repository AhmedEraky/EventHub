package org.eventhub.web.rest.remote;

import org.eventhub.common.model.entity.Hall;
import org.eventhub.facade.hall.HallManagementFacade;
import org.eventhub.facade.hall.HallRetrivalFacade;
import org.eventhub.web.rest.remote.adapter.HallAdapter;
import org.eventhub.web.rest.remote.dto.HallDTO;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * RestController for Hall entity
 *
 * @author Islam El-Rougy
 */
@RestController
@RequestMapping("/api")
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
    @GetMapping(value = "/hall", params = "id")
    public JResponse retrieveHallById(@RequestParam("id") UUID uuid)
    {
        Hall hall = hallRetrivalFacade.getHallById(uuid);
        JResponse hallRetrievalResponse = new JResponse();
        hallRetrievalResponse.setDtoContent(hallAdapter.toHallDTO(hall));
        hallRetrievalResponse.setStatus("success");
        return hallRetrievalResponse;
    }

    /**
     * persist a new Hall in the database
     *
     * @param hallDTO the Dto of the persisted Hall
     * @return {@link JResponse} Json response that wraps the persistent Hall
     * @author Islam El-Rougy (islamelrougy@gmail.com)
     */
    @PostMapping(value = "/hall")
    public JResponse persistHall(@RequestBody HallDTO hallDTO)
    {
        Hall hall = hallAdapter.fromHallDTO(hallDTO);
        Hall persistentHall = hallManagementFacade.creatHall(hall);
        JResponse<HallDTO> hallResponse = new JResponse<>();
        hallResponse.setDtoContent(hallAdapter.toHallDTO(persistentHall));
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
    @PutMapping(value = "/hall")
    public JResponse updateHall(@RequestBody  HallDTO hallDTO)
    {
        Hall hall = hallAdapter.fromHallDTO(hallDTO);
        hallManagementFacade.updateHall(hall);
        JResponse<HallDTO> hallResponse = new JResponse<>();
        hallResponse.setDtoContent(hallAdapter.toHallDTO(hall));
        return hallResponse;
    }

}
