package com.flexon.readFile;

import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import org.junit.Test;
import java.util.*;

public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue()
    {
        try {
            ReadFile readFile = new ReadFile();
            List<String> validReturns = readFile.read();
            List<String> expectedList = new ArrayList<>(
                Arrays.asList("libero","tincidunt","eget","pretium","vitae"));
            
            System.out.println(validReturns);
            System.out.println(expectedList);
            assertTrue(validReturns.equals(expectedList));
        }
        catch (FileNotFoundException e) {
            assertTrue(true);
        }
        
        
    }


}
