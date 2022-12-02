package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day1
{
    public static List<Integer> totalList(String filename, List<Integer> list) throws IOException
    {
        FileReader reader = new FileReader(filename);
        BufferedReader file = new BufferedReader(reader);
        while(true)
        {
            String line = file.readLine();
            System.out.println(line);
            if(line == null)
            {
                break;
            }
        }
        file.close();
        return null;
    }

    public static void main(String[] args) throws IOException 
    {
        List<Integer> l = new ArrayList<>();
        totalList("day1/data.txt", l);
    }
}