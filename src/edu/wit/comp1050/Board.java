package edu.wit.comp1050;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
public class Board {
    int numRows;
    int size;
    String code;
    boolean repeats = true;
    int guessCount;
    boolean win = false;
    Board(int rows, int size){
        numRows = rows;
        this.size = size;
        createCode();
    }
public String createCode(){
        guessCount=0;
    Random rnd = new Random();
    ArrayList<String> colors = new ArrayList<>(Arrays.asList("G","R","B","P","Y","O"));
    win = false;
    code = "";
    for(int i = 0; i < size; i++) {
        int num = rnd.nextInt(colors.size());
        code += colors.get(num);
        if(!repeats){
        colors.remove(num);
        }
    }
    System.out.println(code);
    return code;
}
public String guessCode(String guess){
        if(guess.equals(code)){
            win = true;
        }
        if(guessCount == numRows-1){
            System.out.println("end the game");
            System.exit(0);
        }
        String correction = "";
        guessCount++;
        for(int i = 0; i < code.length();i++){
            if(code.charAt(i) == guess.charAt(i)){
            correction+="G";
            }
            else if(code.contains(guess.substring(i,i+1))) {
                correction+="C";
            }
            else{
                correction+="B";
            }
        }
        System.out.println(correction);
        return correction;
}

}
