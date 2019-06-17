/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.convertor;

import java.util.UUID;
import org.eventhub.common.model.entity.SessionInstructor;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Lamiaa Abdrabou
 */
public class SpeakerConverter implements Converter<String, SessionInstructor> {
     @Override
    public SessionInstructor convert(String instructorUUID) {
        SessionInstructor instructor =new SessionInstructor();
        instructor.setUuid(UUID.fromString(instructorUUID));
        return instructor;
    }
}
