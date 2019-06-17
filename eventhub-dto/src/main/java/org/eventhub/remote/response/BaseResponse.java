package org.eventhub.remote.response;

import org.eventhub.remote.dto.BaseDTO;

public class BaseResponse <DTO extends BaseDTO> {
    private String status;
    private DTO dto;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DTO getDto() {
        return dto;
    }

    public void setDto(DTO dto) {
        this.dto = dto;
    }
}
