package com.cg.restdemo.controller;

import com.cg.restdemo.service.FoodTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  private FoodTruckService foodTruckService;

  @GetMapping("")
  public String index() throws ExecutionException {
    return "index";
  }

  @PostMapping("/applicant/{applicant}")
  @ResponseBody
  public Object getByApplicant(@PathVariable("applicant") String applicant) throws ExecutionException {
    return foodTruckService.getByApplicant(applicant);
  }
}
