package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFileFortuneService implements FortuneService {

  //read in an array of strings
  private String[] data;
  private Random generator = new Random();
  
  RandomFileFortuneService() throws IOException{
    this.data = readFile("randomFortunes.txt");
  }
  
  @Override
  public String getFortune() {
    int randomNum = generator.nextInt(data.length);
    return data[randomNum];
  }
  
  private String[] readFile(String fileName) throws IOException{
    try( BufferedReader br = new BufferedReader(new FileReader(fileName)) ){
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
