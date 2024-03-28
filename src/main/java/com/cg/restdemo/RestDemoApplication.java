package com.cg.restdemo;

import com.cg.restdemo.entity.FoodTruck;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@SpringBootApplication
public class RestDemoApplication {
  private static final String file = "Mobile_Food_Facility_Permit.csv";

  public static void main(String[] args) {
    SpringApplication.run(RestDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner dataLoader() {
    return args -> {
//      Path path = Path.of(Thread.currentThread().getContextClassLoader().getResource("") + "resources/" + file);
//      Path path = Path.of(System.getProperty("user.dir") + File.separator + file);
//      List<String> collect = Files.lines(path)
////              .map(s ->)
//              .collect(Collectors.toList());
//      System.out.println(collect.size());

      String filePath = System.getProperty("user.dir") + File.separator + file;
      try (java.io.FileReader fileReader = new java.io.FileReader(filePath)) {
        new CsvToBeanBuilder<FoodTruck>(fileReader)
                .withType(FoodTruck.class)
                .withIgnoreEmptyLine(true)
                .build().parse();
      } catch (IOException e) {
        System.err.println("IOException while read Csv Data ." + e.getMessage());
      } catch (Exception e) {
        System.err.println("Exception while read Csv Data." + e.getMessage());
      }
    };
  }
}
