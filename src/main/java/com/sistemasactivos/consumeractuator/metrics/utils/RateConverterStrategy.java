package com.sistemasactivos.consumeractuator.metrics.utils;

import com.sistemasactivos.consumeractuator.metrics.interfaces.IStrategyConvert;

/**
 * @author Ivan Andres Brestt
 */

public class RateConverterStrategy implements IStrategyConvert{

    @Override
    public double convertValue(Double value) {
        return (double)(value * 100);
    }

}
