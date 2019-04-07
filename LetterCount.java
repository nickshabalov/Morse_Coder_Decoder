package com.company;

import java.io.*;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class LetterCount {

    public void run(String text) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
           /* int cnt = map.get(ch) != null ? map.get(ch) : 0;
            cnt++;
            map.put(ch, cnt);*/
        }

        Writer writer = null;
        try{
            writer = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Nick\\IdeaProjects\\Morze\\src\\com\\company\\statistics.txt"));
            for (Iterator<Character> it = map.keySet().iterator(); it.hasNext(); ) {
                Character key = it.next();
                writer.write(key + " = " + map.get(key) + "\n");
            }
        }catch (IOException e) {
            System.err.println("Error while writing file: " + e.getLocalizedMessage());
        }finally{
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
