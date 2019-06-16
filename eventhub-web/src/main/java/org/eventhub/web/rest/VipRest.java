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

    @GetMapping(name = "/vips")
    public JResponse getAllVips() {
        List<VipDTO> vipList = new ArrayList<>();
        Iterator<Vip> vipsIterator = retrieveVipFacade.getAll().iterator();
        vipsIterator.forEachRemaining(vip -> {
            VipDTO vipDTO = vipAdapter.toVipDTO(vip);
            vipList.add(vipDTO);
        });
        JResponse vipsResponse = new JResponse();
        vipsResponse.setDtoContent(vipList);
        return vipsResponse;
    }

    @GetMapping(name = "/vips")
    public JResponse getVipById(@RequestParam UUID uuid) {
        Vip vip = retrieveVipFacade.getVipById(uuid);
        JResponse jResponse = new JResponse();
        jResponse.setDtoContent(vipAdapter.toVipDTO(vip));
        return jResponse;
    }

    @PostMapping(name = "/vips")
    public JResponse insertVip(@RequestBody VipDTO vipDTO) {
        Vip vip = vipAdapter.fromVipDTO(vipDTO);
        Vip persistentVip = createVipFacade.createVip(vip);
        JResponse vipResponse = new JResponse();
        vipResponse.setDtoContent(vipAdapter.toVipDTO(persistentVip));
        return vipResponse;
    }

    @PutMapping(name = "/vips")
    public JResponse updateVip(@RequestBody VipDTO vipDTO) {
        Vip vip = vipAdapter.fromVipDTO(vipDTO);
        createVipFacade.updateVip(vip);
        JResponse vipResponse = new JResponse();
        vipResponse.setDtoContent(vipAdapter.toVipDTO(vip));
        return vipResponse;
    }
}
