package com.sistemasactivos.consumeractuator.metrics.exception;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO implements Serializable{
    private String status_code;
    private String status;
    private String message;
}
