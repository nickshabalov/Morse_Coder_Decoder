package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.lang.String;

public class Alphabet {
    private HashMap<String, String> codeMap;
    private HashMap<String, String> decodeMap;


    Alphabet(String filename) {
        InputStream input = null;

        Properties properties = new Properties();
        try {
            input = new FileInputStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return; // Or throw bad exception
            }

            codeMap = new HashMap<>();
            decodeMap = new HashMap<>();

            properties.load(input);

            for (String text : properties.stringPropertyNames()) {
                String morseCode = properties.getProperty(text);

                codeMap.put(text, morseCode);
                decodeMap.put(morseCode, text);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Alphabet() {
        this("C:\\Users\\Nick\\IdeaProjects\\Morze\\src\\com\\company\\morse_code.properties");
    }

    public final String getCodeChar(String str) {
        return codeMap.getOrDefault(str, " ");
    }

    public final String getDecodeChar(String str) {
        return decodeMap.getOrDefault(str, " ");
    }

    public final boolean equals() {



        if(codeMap.size() != decodeMap.size()) {
              return false;
        }

        for (HashMap.Entry<String, String> code : codeMap.entrySet()) {
                if (!code.getKey().equals( decodeMap.getOrDefault(code.getValue(), " "))) {
                    System.out.println("Key = " + code.getValue() + ", Value = " + decodeMap.getOrDefault(code.getValue(), " "));
                    return false;
                }
        }
        /*for (HashMap.Entry<String, String> decode : decodeMap.entrySet()) {
            if (!decode.getKey().equals(codeMap.getOrDefault(decode.getValue(), " "))) {
                System.out.println("Key = " + decode.getValue() + ", Value = " + decodeMap.getOrDefault(decode.getValue(), " "));
                return false;
            }
        }*/

        return true;
    }
}
