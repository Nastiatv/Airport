package com.runa.airport.dto;

import lombok.Data;

@Data
public class ExceptionDto {
    private String exceptionMsg;
    private String exceptionClassName;

    public ExceptionDto(Exception exception) {
        this.exceptionMsg = exception.getMessage();
        this.exceptionClassName = exception.getClass()
                .getName();
    }
}