package com.sistemasactivos.consumeractuator.metrics.interfaces;

import com.sistemasactivos.consumeractuator.metrics.model.MemoryUsage;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ivan Andres Brestt
 */

@Repository
public interface IMemoryUsageRepository extends IMetricRepository<MemoryUsage>{
    
}
    