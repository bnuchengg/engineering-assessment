package com.cg.restdemo.entity.converter;

import com.cg.restdemo.entity.FoodTruck;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class PermitStatusTypeConverter extends AbstractBeanField<FoodTruck.PermitStatus,String> {
    @Override
    protected FoodTruck.PermitStatus convert(String value) throws CsvDataTypeMismatchException {
        try {
            return FoodTruck.PermitStatus.getByValue(value);
        } catch (IllegalArgumentException e) {
            throw new CsvDataTypeMismatchException("Invalid value for enum: " + value);
        }
    }
}
