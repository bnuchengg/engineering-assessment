package com.cg.restdemo.entity.converter;

import com.cg.restdemo.entity.FoodTruck;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class FacilityTypeConverter extends AbstractBeanField<FoodTruck.FacilityType, String> {
  @Override
  protected FoodTruck.FacilityType convert(String value) throws CsvDataTypeMismatchException {
    try {
      return FoodTruck.FacilityType.getByValue(value);
    } catch (IllegalArgumentException e) {
      throw new CsvDataTypeMismatchException("Invalid value for enum: " + value);
    }
  }
}
