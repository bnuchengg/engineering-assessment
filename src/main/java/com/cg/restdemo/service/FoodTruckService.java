package com.cg.restdemo.service;

import com.cg.restdemo.entity.FoodTruck;
import com.cg.restdemo.util.CsvFileParser;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class FoodTruckService {
  private static final String filePath = System.getProperty("user.dir") + File.separator + "Mobile_Food_Facility_Permit.csv";

  public final LoadingCache<String, List<FoodTruck>> foodFacilityLoadingCache = CacheBuilder.newBuilder()
          .initialCapacity(1_000_000)
          .expireAfterWrite(24, TimeUnit.HOURS)
          .build(
                  new CacheLoader<>() {
                    @Override
                    public List<FoodTruck> load(String filePath) {
                      return CsvFileParser.readCsvData(filePath);
                    }
                  });

  public Object getByApplicant(String applicant) throws ExecutionException {
    List<FoodTruck> foodTrucks = foodFacilityLoadingCache.get(filePath);
    return foodTrucks.stream()
            .filter(foodTruck -> applicant.equals(foodTruck.getApplicant()))
            .collect(Collectors.toList());
  }
}
