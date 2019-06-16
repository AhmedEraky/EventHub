package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.BaseEntity;
import org.eventhub.common.model.entity.VipSpeaksInSession;
import org.eventhub.remote.dto.BaseDTO;
import org.eventhub.remote.dto.VipSpeaksInSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * adapter for VipSpeaksInSession
 * @author M. ALI
 */
@Component
public class VipSpeaksInSessionAdapter  implements DtoAdapter{
	
	@Autowired
	SessionAdapter sessionAdapter;
	@Autowired
	VipAdapter vipAdapter;
	
	/**
	 * convert vipSpeaksInSession to vipSpeaksInSessionDTO
	 * @param vipSpeaksInSession
	 * @return vipSpeaksInSessionDTO
	 * @author M. ALI
	 */
	public VipSpeaksInSessionDTO toVipSpeaksInSessionDTO(VipSpeaksInSession vipSpeaksInSession) {
		/*VipSpeaksInSessionDTO vipSpeaksInSessionDTO = new VipSpeaksInSessionDTO();
		vipSpeaksInSessionDTO.setUuid(vipSpeaksInSession.getUuid());
		vipSpeaksInSessionDTO.setSession(sessionAdapter.toSessionDTO(vipSpeaksInSession.getSession()));
		vipSpeaksInSessionDTO.setVip(vipAdapter.toVipDTO(vipSpeaksInSession.getVip()));
		vipSpeaksInSessionDTO.setDeleted(vipSpeaksInSession.isDeleted());
		return vipSpeaksInSessionDTO;*/
		return null;
	}
	
	/**
	 * convert vipSpeaksInSessionDTO to vipSpeaksInSession
	 * @param vipSpeaksInSessionDTO
	 * @return vipSpeaksInSession
	 * @author M. ALI
	 */
	public VipSpeaksInSession fromVipSpeaksInSessionDTO(VipSpeaksInSessionDTO vipSpeaksInSessionDTO) {
		/*VipSpeaksInSession vipSpeaksInSession = new VipSpeaksInSession();
		vipSpeaksInSession.setUuid(vipSpeaksInSessionDTO.getUuid());
		vipSpeaksInSession.setSession(sessionAdapter.fromSessionDTO(vipSpeaksInSessionDTO.getSession()));
		vipSpeaksInSession.setVip(vipAdapter.fromVipDTO(vipSpeaksInSessionDTO.getVip()));
		vipSpeaksInSession.setDeleted(vipSpeaksInSessionDTO.isDeleted());
		return vipSpeaksInSession;*/
		return null;
	}

	@Override
	public BaseEntity fromDto(BaseDTO baseDTO) {
		return null;
	}

	@Override
	public BaseDTO toDto(BaseEntity baseEntity) {
		return null;
	}
}
