package com.sistemasactivos.consumeractuator.metrics.service;

import com.sistemasactivos.consumeractuator.metrics.DTO.MetricResponse;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IDiskTotalService;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IMetricRepository;
import com.sistemasactivos.consumeractuator.metrics.model.DiskTotal;
import com.sistemasactivos.consumeractuator.metrics.utils.BytesToGibibytesConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

@Service
public class DiskTotalServiceImpl extends MetricServiceImpl<DiskTotal> implements IDiskTotalService{

    public DiskTotalServiceImpl(IMetricRepository<DiskTotal> repository, @Value("${thirdPath}") String path) {
        super(repository, path, new DiskTotal(), new BytesToGibibytesConverter());
    }
    
    @Override
    @Scheduled(fixedRate = 10000)
    public Mono<MetricResponse> save(){
        return super.save();
    }

}
