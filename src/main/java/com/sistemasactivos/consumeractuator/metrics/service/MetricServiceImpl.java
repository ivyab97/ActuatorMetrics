package com.sistemasactivos.consumeractuator.metrics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemasactivos.consumeractuator.metrics.DTO.MetricRequest;
import com.sistemasactivos.consumeractuator.metrics.DTO.MetricResponse;
import com.sistemasactivos.consumeractuator.metrics.config.ModelMapperConfig;
import com.sistemasactivos.consumeractuator.metrics.exception.BusinessException;
import com.sistemasactivos.consumeractuator.metrics.exception.ErrorDTO;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IMetricRepository;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IMetricService;
import com.sistemasactivos.consumeractuator.metrics.interfaces.IStrategyConvert;
import com.sistemasactivos.consumeractuator.metrics.model.DiskSpace;
import com.sistemasactivos.consumeractuator.metrics.model.DiskTotal;
import com.sistemasactivos.consumeractuator.metrics.model.MemoryUsage;
import com.sistemasactivos.consumeractuator.metrics.model.Metric;
import com.sistemasactivos.consumeractuator.metrics.model.ProcessCpuUsage;
import jakarta.transaction.Transactional;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

public abstract class MetricServiceImpl<M extends Metric> implements IMetricService{
    
    @Autowired
    WebClient webClient;
    
    protected IMetricRepository<M> repository;
    
    protected String path;
        
    protected M metric;
    
    protected IStrategyConvert strategyConvert;
        
    public MetricServiceImpl(IMetricRepository<M> repository, String path, M metric, IStrategyConvert strategyConvert){
        this.repository = repository;
        this.path = path;
        this.metric = metric;
        this.strategyConvert = strategyConvert;
    }

    
    @Override
    @Transactional
    public Mono<MetricResponse> save() {
         return webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(MetricRequest.class)
                .flatMap(metricRequest -> { 
                    // Mapeo
                    
                    Metric newMetric = createMetricInstance(metric);
                    
                    (newMetric).setValue(strategyConvert.convertValue    //lo convierto a la medida que quiero trabajar
                            ((metricRequest).getMeasurements().get(0).getValue()));
                    // Save
                    repository.save((M)newMetric);
                    // Mapeo la response
                    MetricResponse metricResponse = ModelMapperConfig.modelMapper().map((newMetric), MetricResponse.class);
                 
                    return Mono.just(metricResponse);
                })
                .onErrorMap(WebClientResponseException.class, ex -> {
                    try{
                        ErrorDTO errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), ErrorDTO.class);
                        return new BusinessException(HttpStatus.valueOf(ex.getRawStatusCode()), "");
                    } catch(JsonProcessingException e){
                        return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor, intente más tarde...");
                    }
                })
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontro el recurso")));
    }
    
    private Metric createMetricInstance(M metric) {
    if (metric.getClass() == MemoryUsage.class) {
        return new MemoryUsage();
    }
    if (metric.getClass() == DiskTotal.class) {
        return new DiskTotal();
    }
    if (metric.getClass() == DiskSpace.class) {
        return new DiskSpace();
    }else {
            return new ProcessCpuUsage();
      }
    }
}
