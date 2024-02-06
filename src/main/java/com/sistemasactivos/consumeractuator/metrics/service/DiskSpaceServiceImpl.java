package com.sistemasactivos.consumeractuator.metrics.service;

import com.sistemasactivos.consumeractuator.metrics.DTO.MetricResponse;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IDiskSpaceService;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IMetricRepository;
import com.sistemasactivos.consumeractuator.metrics.model.DiskSpace;
import com.sistemasactivos.consumeractuator.metrics.utils.BytesToGibibytesConverterStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author Ivan Andres Brestt
 */

@Service
public class DiskSpaceServiceImpl extends MetricServiceImpl<DiskSpace> implements IDiskSpaceService{

    public DiskSpaceServiceImpl(IMetricRepository<DiskSpace> repository, @Value("${firstPath}") String path) {
        super(repository, path, new DiskSpace(), new BytesToGibibytesConverterStrategy());
    }
    
    @Override
    @Scheduled(fixedRate = 10000)
    public Mono<MetricResponse> save() {
        return super.save();
    }
  
}
