/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.BaseEntity;
import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.remote.dto.BaseDTO;
import org.eventhub.remote.dto.JobTitleDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author FARES-LAP
 */
@Component
public class JobTitleAdapter implements DtoAdapter {

    @Override
    public BaseEntity fromDto(BaseDTO baseDTO) {
        return null;
    }

    @Override
    public BaseDTO toDto(BaseEntity baseEntity) {
        return null;
    }
}
