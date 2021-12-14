package com.neogedom.professorvacancies.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class StandardError {
    private Integer status;
    private String msg;
    private LocalDateTime timestamp;


}
