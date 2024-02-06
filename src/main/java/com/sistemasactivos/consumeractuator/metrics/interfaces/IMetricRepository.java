package com.sistemasactivos.consumeractuator.metrics.interfaces;

import com.sistemasactivos.consumeractuator.metrics.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Ivan Andres Brestt
 */

@NoRepositoryBean
public interface IMetricRepository<M extends Metric> extends JpaRepository<M, Long> {

}
