package com.cg.restdemo.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DistrictsInfo {
  @CsvBindByName(column = "Fire Prevention Districts")
  private String firePreventionDistricts;
  @CsvBindByName(column = "Police Districts")
  private String policeDistricts;
  @CsvBindByName(column = "Supervisor Districts")
  private String supervisorDistracts;
}