package com.sistemasactivos.consumeractuator.metrics.service;

import com.sistemasactivos.consumeractuator.metrics.DTO.MetricResponse;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IMemoryUsageService;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IMetricRepository;
import com.sistemasactivos.consumeractuator.metrics.model.MemoryUsage;
import com.sistemasactivos.consumeractuator.metrics.utils.BytesToGibibytesConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


/**
 *
 * @author Ivan Andres Brestt
 */

@Service
public class MemoryUsageServiceImpl extends MetricServiceImpl<MemoryUsage> implements IMemoryUsageService{

    public MemoryUsageServiceImpl(IMetricRepository<MemoryUsage> repository, @Value("${secondPath}") String path) {
        super(repository, path, new MemoryUsage(), new BytesToGibibytesConverter());
    }
    
    @Override   
    @Scheduled(fixedRate = 5000)
    public Mono<MetricResponse> save() {
        return super.save();
    }

}
