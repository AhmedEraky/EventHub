/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.convertor;

import java.util.UUID;
import org.eventhub.common.model.entity.Hall;
import org.springframework.core.convert.converter.Converter;
/**
 *
 * @author Hamada Abdrabou
 */
public class HallConverter implements Converter<String, Hall> {
    @Override
    public Hall convert(String sessionUUID) {
        Hall hall =new Hall();
        hall.setUuid(UUID.fromString(sessionUUID));
        return hall;
    }
    
}
