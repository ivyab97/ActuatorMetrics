package com.sistemasactivos.consumeractuator.metrics.service;

import com.sistemasactivos.consumeractuator.metrics.DTO.MetricResponse;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IMetricRepository;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IProcessCpuUsageService;
import com.sistemasactivos.consumeractuator.metrics.model.ProcessCpuUsage;
import com.sistemasactivos.consumeractuator.metrics.utils.RateConverterStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

@Service
public class ProcessCpuUsageServiceImpl extends MetricServiceImpl<ProcessCpuUsage> implements IProcessCpuUsageService{

    public ProcessCpuUsageServiceImpl(IMetricRepository<ProcessCpuUsage> repository, @Value("${fourthPath}") String path) {
        super(repository, path, new ProcessCpuUsage(), new RateConverterStrategy());
    }
    
    @Override
    @Scheduled(fixedRate = 10000)
    public Mono<MetricResponse> save(){
        return super.save();
    }

}
