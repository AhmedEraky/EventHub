/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

/**
 * @param D DTO which can be object or array of objects
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */
public class JResponse<D> {
    String status;
    D dtoContent;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public D getDtoContent() {
        return dtoContent;
    }

    public void setDtoContent(D dtoContent) {
        this.dtoContent = dtoContent;
    }
    
}
