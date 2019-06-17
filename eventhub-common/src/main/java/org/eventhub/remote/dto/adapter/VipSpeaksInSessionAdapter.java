package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.VipSpeaksInSession;
import org.eventhub.remote.dto.VipSpeaksInSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VipSpeaksInSessionAdapter extends GenericAdapter<VipSpeaksInSession, VipSpeaksInSessionDTO> {

	@Autowired
	SessionAdapter sessionAdapter;
	@Autowired
	VipAdapter vipAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(sessionAdapter, vipAdapter);
	}
	
	public VipSpeaksInSessionDTO toVipSpeaksInSessionDTO(VipSpeaksInSession vipSpeaksInSession) {
		return toDTO(vipSpeaksInSession);
	}
	
	public VipSpeaksInSession fromVipSpeaksInSession(VipSpeaksInSessionDTO vipSpeaksInSessionDTO) {
		return fromDTO(vipSpeaksInSessionDTO);
	}
	
}
