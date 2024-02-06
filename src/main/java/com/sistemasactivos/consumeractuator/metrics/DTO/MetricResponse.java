package com.sistemasactivos.consumeractuator.metrics.DTO;

import java.io.Serializable;
import java.util.Date;
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
public class MetricResponse implements Serializable{
    private Double value;
    private Date createdAt;
}
