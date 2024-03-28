package com.cg.restdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
      Path path = Path.of(System.getProperty("user.dir") + File.separator + file);
      List<String> collect = Files.lines(path)
//              .map(s ->)
              .collect(Collectors.toList());
      System.out.println(collect.size());
    };
  }
}
