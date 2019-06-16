package org.eventhub.remote.adapter;

import java.util.ArrayList;
import java.util.List;
import org.eventhub.common.model.entity.Vip;
import org.eventhub.common.model.entity.VipSpeaksInSession;
import org.eventhub.remote.dto.VipDTO;
import org.eventhub.remote.dto.VipSpeaksInSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VipAdapter {

    @Autowired
    JobTitleAdapter jobTitleAdapter;
    @Autowired
    VipSpeaksInSessionAdapter vipSpeaksInSessionAdapter;
    @Autowired
    OrganizationAdapter organizationAdapter;

    public VipDTO toVipDTO(Vip vip) {
        VipDTO vipDTO = new VipDTO();
        vipDTO.setBio(vip.getBio());
        vipDTO.setDeleted(vip.isDeleted());
        vipDTO.setImage(vip.getImage());
        vipDTO.setJobTitle(jobTitleAdapter.toJobTitleDTO(vip.getJobTitle()));
        vipDTO.setName(vip.getName());
        vipDTO.setOrganization(organizationAdapter.toOrganizationDTO(vip.getOrganization()));
        vipDTO.setUuid(vip.getUuid());

        List<VipSpeaksInSessionDTO> vipSpeaksInSessionDTOList = new ArrayList<>();
        vip.getVipSpeaksInSessions().forEach(vipSpeaksInSessions
                -> vipSpeaksInSessionDTOList.add(vipSpeaksInSessionAdapter.toVipSpeaksInSessionDTO(vipSpeaksInSessions)));
        vipDTO.setVipSpeaksInSessions(vipSpeaksInSessionDTOList);
        return vipDTO;
    }

    public Vip fromVipDTO(VipDTO vipDTO) {
        Vip vip = new Vip();
        vip.setBio(vipDTO.getBio());
        vip.setUuid(vipDTO.getUuid());
        vip.setImage(vipDTO.getImage());
        vip.setJobTitle(jobTitleAdapter.fromJobTitleDTO(vip.getJobTitle()));
        vip.setName(vip.getName());
        vip.setOrganization(organizationAdapter.fromOrganizationDTO(vip.getOrganization()));

        List<VipSpeaksInSession> vipSpeaksInSessionList = new ArrayList<>();
        vipDTO.getVipSpeaksInSessions().forEach(vipSpeaksInSessions
                -> vipSpeaksInSessionList.add(vipSpeaksInSessionAdapter.fromVipSpeaksInSessionDTO(vipSpeaksInSessions)));
        vip.setVipSpeaksInSessions(vipSpeaksInSessionList);
        return vip;
    }

}
