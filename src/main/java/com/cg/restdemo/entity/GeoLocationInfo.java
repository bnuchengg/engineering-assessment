package com.cg.restdemo.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class GeoLocationInfo {

  @CsvBindByName(column = "Latitude")
  private String latitude;

  @CsvBindByName(column = "Longitude")
  private String longitude;

  @CsvBindByName(column = "X")
  private String x;

  @CsvBindByName(column = "Y")
  private String y;
}
