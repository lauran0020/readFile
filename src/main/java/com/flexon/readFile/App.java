package com.flexon.readFile;

import java.io.FileNotFoundException;
import java.util.*;

public class App 
{
   
    public static void main(String[] args){
        
        ReadFile r = new ReadFile();
        try {
            List<String> ans = r.read();
            for (String s : ans) {
                System.out.println(s);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("******Invalid File Directory******");
            System.out.println("Please create and name the file as example.txt in the same package of App.java:");
            System.out.println("src/files/example.txt");
        }
        
    }
        
    
}
