package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.BaseEntity;
import org.eventhub.remote.dto.BaseDTO;

public interface DtoAdapter<ENTITY extends BaseEntity,DTO extends BaseDTO> {
    public ENTITY fromDto(DTO baseDTO);
    public DTO toDto(ENTITY baseEntity);
}
