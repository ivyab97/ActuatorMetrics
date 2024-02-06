package com.sistemasactivos.consumeractuator.metrics.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Ivan Andres Brestt
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDTO implements Serializable{
    private String statistic;
    private Double value;
}
