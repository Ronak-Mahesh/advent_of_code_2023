package com.aoc.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextParser
{
    public static void main(String[] args)
    {
        int total = 0;
        HashMap<Integer, String> hashMap = new HashMap<>();
        initializeNumberMap(hashMap);
        String file = "day_1/com/aoc/day1/day_1_input.txt";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while((line = br.readLine()) != null)
            {
                boolean foundFirst = false;
                String first = "0";
                String last = "0";
                String number = "";
                for(int i = 0; i<line.length(); i++)
                {
                    if(Character.isDigit(line.charAt(i)))
                    {
                        if(!foundFirst)
                        {
                            first = String.valueOf(line.charAt(i));
                            last = String.valueOf(line.charAt(i));
                            foundFirst = true;
                        }
                        else
                            last = String.valueOf(line.charAt(i));
                        number = "";
                    }
                    else
                    {
                        number += line.charAt(i);

                        for(int j = 0; j<9; j++)
                        {
                            if(number.contains(hashMap.get(j)))
                            {
                                if(!foundFirst)
                                {
                                    first = String.valueOf((j+1));
                                    last = String.valueOf((j+1));
                                    foundFirst = true;
                                }
                                else
                                    last = String.valueOf((j+1));
                                number = number.substring(number.length()-1);
                            }
                        }
                    }
                }
                System.out.println("First: "+first);
                System.out.println("Last: "+last);
                String value = first + last;
                total += Integer.parseInt(value);
                System.out.println("Current Total: "+total);
            }
            System.out.println("Total: " + total);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void initializeNumberMap(HashMap<Integer, String> numberMap)
    {
        numberMap.put(0, "one");
        numberMap.put(1, "two");
        numberMap.put(2, "three");
        numberMap.put(3, "four");
        numberMap.put(4, "five");
        numberMap.put(5, "six");
        numberMap.put(6, "seven");
        numberMap.put(7, "eight");
        numberMap.put(8, "nine");
    }
}
