package com.sistemasactivos.consumeractuator.metrics.interfaces;

import com.sistemasactivos.consumeractuator.metrics.model.DiskSpace;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ivan Andres Brestt
 */

@Repository
public interface IDiskSpaceRepository extends IMetricRepository<DiskSpace>{
   
}
