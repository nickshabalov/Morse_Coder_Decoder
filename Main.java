package com.company;

import java.lang.String;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner str = new Scanner(System.in);
        String s =  str.nextLine();
        String[] com = s.split(" ");
        Coder morse = new Coder();
        if(com[0].equals("code"))
        {
            morse.code(com[1]);
        }
        else if(com[0].equals("decode"))
        {
            morse.decode(com[1]);
        }

    }
}
