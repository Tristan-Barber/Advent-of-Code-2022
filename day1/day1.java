package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day1
{
    //Returns a list of the total of calories each elf has
    public static void totalList(String filename, List<Integer> list) throws IOException
    {
        //Enables me to read through the fie:
        FileReader reader = new FileReader(filename);
        BufferedReader file = new BufferedReader(reader);
        int totalCal = 0;

        //Reads the lines from the file and stops when it hits the end
        while(true)
        {
            String line = file.readLine();
            if(line == null)
            {
                break;
            }
            else if(line.strip()=="")
            {
                list.add(totalCal);
                totalCal = 0;
            }
            else
            {
                totalCal += Integer.parseInt(line);
            }
        }
        file.close();
    }

    public static int findBiggest(List<Integer> list)
    {
        int highest = 0;
        for(int total : list)
        {
            if(total > highest)
            {
                highest = total;
            }
        }
        return highest;
    }

    public static List<Integer> findTopThree(List<Integer> list)
    {
        int index = 0;
        int highest = 0;
        List<Integer> topThree = new ArrayList<>();
        List<Integer> copy = list;
        for(int total : list)
        {
            if(total > highest)
            {
                highest = total;
                index = list.indexOf(highest);
            }
        }
        topThree.add(highest);
        highest = 0;
        copy.remove(index);
        for(int total : list)
        {
            if(total > highest)
            {
                highest = total;
                index = list.indexOf(highest);
            }
        }
        topThree.add(highest);
        highest = 0;
        copy.remove(index);

        for(int total : list)
        {
            if(total > highest)
            {
                highest = total;
                index = list.indexOf(highest);
            }
        }
        topThree.add(highest);
        highest = 0;
        copy.remove(index);

        return topThree;
    }

    public static void main(String[] args) throws IOException 
    {
        List<Integer> l = new ArrayList<>();
        totalList("day1/data.txt", l);
        System.out.println("Highest:");
        System.out.println(findBiggest(l));
        System.out.println("Top 3:");
        List<Integer> top = findTopThree(l);
        System.out.println(top);
        System.out.println("Top 3 Total:");
        int total = 0;
        for(int element : top)
        {
            total += element;
        }
        System.out.println(total);
    }
}