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
public class TagDTO implements Serializable{
    private String tag;
    private List<String> values;
}
