/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Vip;
import org.eventhub.facade.vip.CreateVipFacade;
import org.eventhub.facade.vip.RetrieveVipFacade;
import org.eventhub.web.rest.remote.adapter.VipAdapter;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.eventhub.web.rest.remote.dto.VipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for Vip entity
 *
 * @author Fares Helmy (fares.helmy93@gmail.com)
 */
@RestController
@RequestMapping("/api")
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
    @GetMapping("/vips")
    public JResponse<List<VipDTO>> getAllVips() {
        List<Vip> vipList = retrieveVipFacade.getAll();
        List<VipDTO> vipDTOs = new ArrayList<>();
        for (Vip vip : vipList) {
            vipDTOs.add(vipAdapter.toVipDTO(vip));
        }
        JResponse vipsResponse = new JResponse();
        vipsResponse.setDtoContent(vipDTOs);
        vipsResponse.setStatus("success");
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
    @GetMapping("/vips/{id}")
    public JResponse<VipDTO> getVipById(@PathVariable("id") UUID uuid) {
        Vip vip = retrieveVipFacade.getVipById(uuid);
        JResponse jResponse = new JResponse();
        jResponse.setDtoContent(vipAdapter.toVipDTO(vip));
        jResponse.setStatus("success");
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
    @PostMapping("/vips")
    public JResponse<VipDTO> insertVip(@RequestBody VipDTO vipDTO) {
        Vip vip = vipAdapter.fromVipDTO(vipDTO);
        JResponse vipResponse = new JResponse();
        try {
            Vip persistentVip = createVipFacade.createVip(vip);
            vipResponse.setDtoContent(vipAdapter.toVipDTO(persistentVip));
            vipResponse.setStatus("success");
        } catch (Exception e) {
            vipResponse.setDtoContent(new VipDTO());
            vipResponse.setStatus("fail");
        }
        return vipResponse;
    }

    /**
     * update a specific vip record
     *
     * @param vipDTO the Dto of the vip to be updated
     * @return {@link JResponse} Json response that wraps the updated vip entity
     * @author Fares Helmy (fares.helmy93@gmail.com)
     */
    @PutMapping("/vips")
    public JResponse<VipDTO> updateVip(@RequestBody VipDTO vipDTO) {
        Vip vip = vipAdapter.fromVipDTO(vipDTO);
        JResponse vipResponse = new JResponse();

        try {
            createVipFacade.updateVip(vip);
            vipResponse.setDtoContent(vipAdapter.toVipDTO(vip));
            vipResponse.setStatus("success");
        } catch (Exception e) {
            vipResponse.setDtoContent(new VipDTO());
            vipResponse.setStatus("fail");
        }
        return vipResponse;
    }
}
