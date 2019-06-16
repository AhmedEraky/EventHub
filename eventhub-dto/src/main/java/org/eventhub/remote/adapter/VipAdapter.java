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
public class VipAdapter implements DtoAdapter<Vip, VipDTO> {

    @Autowired
    JobTitleAdapter jobTitleAdapter;
    @Autowired
    VipSpeaksInSessionAdapter vipSpeaksInSessionAdapter;
    @Autowired
    OrganizationAdapter organizationAdapter;

    @Override
    public Vip fromDto(VipDTO baseDTO) {
        Vip vip = new Vip();
        vip.setBio(baseDTO.getBio());
        vip.setUuid(baseDTO.getUuid());
        vip.setImage(baseDTO.getImage());
        vip.setJobTitle(jobTitleAdapter.fromDto(baseDTO.getJobTitle()));
        vip.setName(vip.getName());
        vip.setOrganization(organizationAdapter.fromDto(baseDTO.getOrganization()));

        List<VipSpeaksInSession> vipSpeaksInSessionList = new ArrayList<>();
        baseDTO.getVipSpeaksInSessions().forEach(vipSpeaksInSessions
                -> vipSpeaksInSessionList.add(vipSpeaksInSessionAdapter.fromDto(vipSpeaksInSessions)));
        vip.setVipSpeaksInSessions(vipSpeaksInSessionList);
        return vip;
    }

    @Override
    public VipDTO toDto(Vip baseEntity) {
        VipDTO vipDTO = new VipDTO();
        vipDTO.setBio(baseEntity.getBio());
        vipDTO.setDeleted(baseEntity.isDeleted());
        vipDTO.setImage(baseEntity.getImage());
        vipDTO.setJobTitle(jobTitleAdapter.toDto(baseEntity.getJobTitle()));
        vipDTO.setName(baseEntity.getName());
        vipDTO.setOrganization(organizationAdapter.toDto(baseEntity.getOrganization()));
        vipDTO.setUuid(baseEntity.getUuid());

        List<VipSpeaksInSessionDTO> vipSpeaksInSessionDTOList = new ArrayList<>();
        baseEntity.getVipSpeaksInSessions().forEach(vipSpeaksInSessions
                -> vipSpeaksInSessionDTOList.add(vipSpeaksInSessionAdapter.toDto(vipSpeaksInSessions)));
        vipDTO.setVipSpeaksInSessions(vipSpeaksInSessionDTOList);
        return vipDTO;
    }
}
