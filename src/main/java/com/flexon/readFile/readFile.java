package com.flexon.readFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class readFile{
    String fp;
    readFile(String fp) {
            this.fp = fp;
        }
        
    public List<String> read() throws FileNotFoundException{
        // define the filepath and creat the file object
        
        File f = new File(fp);
        Scanner fileData = new Scanner(f);

        // create ans list to record words that appear more than 5 times
        // create wordOrder list to record the order of words that longer than 3 characters
        // create word2frequency hashmap to record word frequency for words longer than 3 characters.
        List<String> ans = new ArrayList<>();
        List<String> wordOrder = new ArrayList<>();
        Map<String, Integer> word2frequency = new HashMap<>();

        // iterate words in every line, if the word is previous visited, increase the frequency else
        // add it to the order list and set the frequency in the hashmap as 1.
        String regex = "[!._,'@? ]";
        while (fileData.hasNextLine()) {
            String line = fileData.nextLine();
            StringTokenizer words = new StringTokenizer(line, regex);
            while (words.hasMoreTokens()) {
                String word = words.nextToken();
                
                // make sure the word is longer than 3 characters 
                if (word.length() <= 3) {
                    continue;
                }

                if (wordOrder.contains(word)) {
                    int cur_freq = word2frequency.get(word);
                    word2frequency.put(word, cur_freq + 1);
                } else {
                    wordOrder.add(word);
                    word2frequency.put(word, 1);
                }
            }
        }
        fileData.close();

        // pick words that are more frequently visited by 5 times
        for (String w : wordOrder) {

            // make sure that the word appears for more than 5 times
            if (word2frequency.get(w) > 5) {
                ans.add(w);
            }
        }

        // after reversing qualified words, return the list.
        Collections.reverse(ans);
        return ans;
    }


        

}
    
