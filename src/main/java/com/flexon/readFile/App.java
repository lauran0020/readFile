package com.flexon.readFile;

import java.io.FileNotFoundException;
import java.util.*;

public class App 
{
       
    public static void main(String[] args){
        final String fp =  "src/files/example.txt";
        readFile r = new readFile(fp);
        try {
            List<String> ans = r.read();
            for (String s : ans) {
                System.out.println(s);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("******Invalid File Directory******");
            System.out.println("Please create an example.txt file in the following directory:");
            System.out.println("src/files/example.txt");
        }
        
    }
        
    
}
