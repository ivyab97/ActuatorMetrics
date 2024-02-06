package com.sistemasactivos.consumeractuator.metrics.interfaces;

import com.sistemasactivos.consumeractuator.metrics.DTO.MetricResponse;
import reactor.core.publisher.Mono;

/**
 *
 * @author Ivan Andres Brestt
 */

public interface IMetricService{
    public Mono<MetricResponse> save ();
}
