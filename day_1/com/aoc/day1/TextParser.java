package com.aoc.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextParser
{
    public static void main(String[] args)
    {
        int total = 0;
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
                    }
                }
                String value = first + last;
                total += Integer.parseInt(value);
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
}
