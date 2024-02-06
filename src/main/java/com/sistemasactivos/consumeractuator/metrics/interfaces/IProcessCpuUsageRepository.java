package com.sistemasactivos.consumeractuator.metrics.interfaces;

import com.sistemasactivos.consumeractuator.metrics.model.ProcessCpuUsage;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Andres Brestt
 */

@Repository
public interface IProcessCpuUsageRepository extends IMetricRepository<ProcessCpuUsage>{

}
