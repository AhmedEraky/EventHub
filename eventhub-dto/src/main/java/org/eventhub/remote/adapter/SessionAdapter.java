package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.BaseEntity;
import org.eventhub.common.model.entity.Session;
import org.eventhub.remote.dto.BaseDTO;
import org.eventhub.remote.dto.SessionDTO;
import org.springframework.stereotype.Component;

@Component
public class SessionAdapter implements DtoAdapter {


	@Override
	public BaseEntity fromDto(BaseDTO baseDTO) {
		return null;
	}

	@Override
	public BaseDTO toDto(BaseEntity baseEntity) {
		return null;
	}
}
