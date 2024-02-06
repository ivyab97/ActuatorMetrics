package com.sistemasactivos.consumeractuator.metrics.utils;

import com.sistemasactivos.consumeractuator.metrics.interfaces.IStrategyConvert;

/**
 *
 * @author Ivan Andres Brestt
 */
public class BytesToGibibytesConverterStrategy implements IStrategyConvert{
    
    @Override
    public double convertValue(Double value) {
        return (double) value / Math.pow(2, 30);
    }
}
