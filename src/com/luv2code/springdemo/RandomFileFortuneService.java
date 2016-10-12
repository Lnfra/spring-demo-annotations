package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class RandomFileFortuneService implements FortuneService {

  //read in an array of strings
  private String[] data;
  private Random generator = new Random();
  
//  public RandomFileFortuneService() throws IOException{
//    this.data = readFile();
//  }
  
  @Override
  public String getFortune() {
    int randomNum = generator.nextInt(data.length);
    return data[randomNum];
  }
  
  @PostConstruct
  private String[] readFile() throws IOException{
    System.out.println(">> RandomFileFortuneSevice: post construct reading file from filesys");
    try( BufferedReader br = new BufferedReader(new FileReader("randomFortunes.txt")) ){
      String line = br.readLine();
      ArrayList<String> temp = new ArrayList<String>();
        
      while( line != null){
        temp.add(line);
        line = br.readLine();
      }
      return temp.toArray(new String[0]);
    }
  }

}
