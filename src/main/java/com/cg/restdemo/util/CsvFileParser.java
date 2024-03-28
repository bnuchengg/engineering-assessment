package com.cg.restdemo.util;

import com.cg.restdemo.entity.FoodTruck;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParser {

  public static List<FoodTruck> readCsvData(String filePath) {
    try (java.io.FileReader fileReader = new java.io.FileReader(filePath)) {
      return new CsvToBeanBuilder<FoodTruck>(fileReader)
              .withType(FoodTruck.class)
              .withIgnoreEmptyLine(true)
              .build().parse();
    } catch (IOException e) {
      System.err.println("IOException while read Csv Data ." + e.getMessage());
    } catch (Exception e) {
      System.err.println("Exception while read Csv Data." + e.getMessage());
    }
    return new ArrayList<>();
  }

}
