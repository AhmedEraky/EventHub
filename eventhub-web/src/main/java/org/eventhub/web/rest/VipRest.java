/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Vip;
import org.eventhub.dal.dao.VipRepository;
import org.eventhub.facade.vip.CreateVipFacade;
import org.eventhub.facade.vip.RetrieveVipFacade;
import org.eventhub.remote.adapter.VipAdapter;
import org.eventhub.remote.dto.JResponse;
import org.eventhub.remote.dto.VipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for Vip entity
 *
 * @author FARES-LAP
 */
@RestController
public class VipRest {

    @Autowired
    CreateVipFacade createVipFacade;
    @Autowired
    RetrieveVipFacade retrieveVipFacade;
    @Autowired
    VipAdapter vipAdapter;

    /**
     * get all vip records
     *
     * @return {@link JResponse} Json response that wraps the required all vip
     * entities
     * @author Fares Helmy (fares.helmy93@gmail.com)
     */
    @GetMapping(name = "/vips")
    public JResponse getAllVips() {
        List<VipDTO> vipList = new ArrayList<>();
        Iterator<Vip> vipsIterator = retrieveVipFacade.getAll().iterator();
        vipsIterator.forEachRemaining(vip -> {
            VipDTO vipDTO = vipAdapter.toDto(vip);
            vipList.add(vipDTO);
        });
        JResponse vipsResponse = new JResponse();
        vipsResponse.setDtoContent(vipList);
        return vipsResponse;
    }

    /**
     * get vip record by uuid
     *
     * @param uuid the id of the required vip
     * @return {@link JResponse} Json response that wraps the required vip
     * entity
     * @author Fares Helmy (fares.helmy93@gmail.com)
     */
    @GetMapping(name = "/vips", params = "id")
    public JResponse getVipById(@RequestParam("id") UUID uuid) {
        Vip vip = retrieveVipFacade.getVipById(uuid);
        JResponse jResponse = new JResponse();
        jResponse.setDtoContent(vipAdapter.toDto(vip));
        return jResponse;
    }

    /**
     * persist a new vip entity in the database
     *
     * @param vipDTO the Dto of the requested vip
     * @return {@link JResponse} Json response that wraps the persistent vip
     * entity
     * @author Fares Helmy (fares.helmy93@gmail.com)
     */
    @PostMapping(name = "/vips")
    public JResponse insertVip(@RequestBody VipDTO vipDTO) {
        Vip vip = vipAdapter.fromDto(vipDTO);
        Vip persistentVip = createVipFacade.createVip(vip);
        JResponse vipResponse = new JResponse();
        vipResponse.setDtoContent(vipAdapter.toDto(persistentVip));
        vipResponse.setStatus("success");
        return vipResponse;
    }

    /**
     * update a specific vip record
     *
     * @param vipDTO the Dto of the vip to be updated
     * @return {@link JResponse} Json response that wraps the updated vip entity
     * @author Fares Helmy (fares.helmy93@gmail.com)
     */
    @PutMapping(name = "/vips")
    public JResponse updateVip(@RequestBody VipDTO vipDTO) {
        Vip vip = vipAdapter.fromDto(vipDTO);
        createVipFacade.updateVip(vip);
        JResponse vipResponse = new JResponse();
        vipResponse.setDtoContent(vipAdapter.toDto(vip));
        return vipResponse;
    }
}
