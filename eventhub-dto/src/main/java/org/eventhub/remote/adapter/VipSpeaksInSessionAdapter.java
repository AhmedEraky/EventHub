package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.VipSpeaksInSession;
import org.eventhub.remote.dto.VipSpeaksInSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * adapter for VipSpeaksInSession
 *
 * @author M. ALI
 */
@Component
public class VipSpeaksInSessionAdapter implements DtoAdapter<VipSpeaksInSession, VipSpeaksInSessionDTO> {

    @Autowired
    SessionAdapter sessionAdapter;
    @Autowired
    VipAdapter vipAdapter;

    /**
     * convert vipSpeaksInSessionDTO to vipSpeaksInSession
     *
     * @param vipSpeaksInSessionDTO
     * @return vipSpeaksInSession
     * @author M. ALI
     */
    @Override
    public VipSpeaksInSession fromDto(VipSpeaksInSessionDTO baseDTO) {
        VipSpeaksInSession vipSpeaksInSession = new VipSpeaksInSession();
        vipSpeaksInSession.setUuid(baseDTO.getUuid());
        vipSpeaksInSession.setSession(sessionAdapter.fromDto(baseDTO.getSession()));
        vipSpeaksInSession.setVip(vipAdapter.fromDto(baseDTO.getVip()));
        vipSpeaksInSession.setDeleted(baseDTO.isDeleted());
        return vipSpeaksInSession;
    }

    /**
     * convert vipSpeaksInSession to vipSpeaksInSessionDTO
     *
     * @param vipSpeaksInSession
     * @return vipSpeaksInSessionDTO
     * @author M. ALI
     */
    @Override
    public VipSpeaksInSessionDTO toDto(VipSpeaksInSession baseEntity) {
        VipSpeaksInSessionDTO vipSpeaksInSessionDTO = new VipSpeaksInSessionDTO();
        vipSpeaksInSessionDTO.setUuid(baseEntity.getUuid());
        vipSpeaksInSessionDTO.setSession(sessionAdapter.toDto(baseEntity.getSession()));
        vipSpeaksInSessionDTO.setVip(vipAdapter.toDto(baseEntity.getVip()));
        vipSpeaksInSessionDTO.setDeleted(baseEntity.isDeleted());
        return vipSpeaksInSessionDTO;
    }
}
