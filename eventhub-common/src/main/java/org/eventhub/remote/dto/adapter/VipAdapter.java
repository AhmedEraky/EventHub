package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Vip;
import org.eventhub.remote.dto.VipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VipAdapter extends GenericAdapter<Vip, VipDTO> {
	
	@Autowired
	VipSpeaksInSessionAdapter vipSpeaksInSessionAdapter;
	@Autowired
	JobTitleAdapter jobTitleAdapter;
	@Autowired
	OrganizationAdapter organizationAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(vipSpeaksInSessionAdapter, jobTitleAdapter, organizationAdapter);
	}
	
	public VipDTO toVipDTO(Vip vip) {
		return toDTO(vip);
	}
	
	public Vip fromVipDTO(VipDTO vipDTO) {
		return fromDTO(vipDTO);
	}

}
