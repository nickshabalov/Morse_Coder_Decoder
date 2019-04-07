package com.company;

import java.lang.String;
import java.io.*;

public class Coder {
private Alphabet alphabet = new Alphabet();

    private final String readfile (String filename)
    {
        Reader reader = null;
        StringBuilder InpurData = new StringBuilder();
        try{
            reader = new InputStreamReader(new FileInputStream(filename));
            int data = reader.read();
            while(data != -1) {
                char theChar = (char) data;
                  InpurData.append(theChar);
                  data = reader.read();

            }

        }catch (IOException e){
            System.err.println("Error while reading file: " + e.getLocalizedMessage());

        }finally{
            if (null != reader) {
                try {
                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
System.out.println(alphabet.equals());
        return InpurData.toString();
    }

    private final void writefile (String OutputData)
    {
        //здесь можно генеировать имя файла -> тогда каждый раз можно создавать новый файл
        //Но мне лень потом комп чистить))
        Writer writer = null;
        try{
            writer = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Nick\\IdeaProjects\\Morze\\src\\com\\company\\output.txt"));

            writer.write(OutputData);
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


    public final void code(String filename) {

        String textInput = readfile(filename);

        LetterCount Count = new LetterCount();
        Count.run(textInput);

        StringBuilder coded = new StringBuilder();
        int textLength = textInput.length();

        for (int i = 0; i < textLength; i++) {
            String lookup = Character.toString(textInput.toLowerCase().charAt(i));
            coded.append(alphabet.getCodeChar(lookup));
           coded.append(" ");
        }

        writefile(coded.toString());
    }


    public final void decode(String filename) {

        String morseInput = readfile(filename);

        StringBuilder decoded = new StringBuilder();

        for (String morseCode : morseInput.split(" ")) {
            decoded.append(alphabet.getDecodeChar(morseCode));
        }

        LetterCount Count = new LetterCount();
        Count.run(decoded.toString());

        writefile(decoded.toString());
    }
}

