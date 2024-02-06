package com.sistemasactivos.consumeractuator.metrics.interfaces;

import com.sistemasactivos.consumeractuator.metrics.model.DiskTotal;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Andres Brestt
 */

@Repository
public interface IDiskTotalRepository extends IMetricRepository<DiskTotal> {

}
