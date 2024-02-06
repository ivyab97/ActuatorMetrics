package com.sistemasactivos.consumeractuator.metrics.DTO;

import java.io.Serializable;
import java.util.List;
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
public class MetricRequest implements Serializable{
    private String name;
    private String description;
    private String baseUnit;
    private List<MeasurementDTO> measurements;
    private List<TagDTO> availableTags;
}
