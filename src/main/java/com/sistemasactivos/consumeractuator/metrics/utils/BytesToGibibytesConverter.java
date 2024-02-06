package com.sistemasactivos.consumeractuator.metrics.utils;

import com.sistemasactivos.consumeractuator.metrics.interfaces.IStrategyConvert;

/**
 *
 * @author Ivan Andres Brestt
 */
public class BytesToGibibytesConverter implements IStrategyConvert{
    public static double convertBytesToGibibytes(Double bytes) {
        return (double) bytes / Math.pow(2, 30);
    }

    @Override
    public double convertValue(Double value) {
        return (double) value / Math.pow(2, 30);
    }
}
