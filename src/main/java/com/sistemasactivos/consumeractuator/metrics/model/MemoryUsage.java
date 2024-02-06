package com.sistemasactivos.consumeractuator.metrics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Ivan Andres Brestt
 */

@Entity

@Setter
@Getter
@Table(name = "memory_usage")
@NoArgsConstructor

public class MemoryUsage extends Metric{
    
}
