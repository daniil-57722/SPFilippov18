package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read_and_mult {
    public Object read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("mult.txt"));
            String line =  reader.readLine();
            System.out.println(line);
            String[] znach = line.split(" ?\\* ?");
            line_for_test(line);
            System.out.printf("Ответ >> %d",(int)Math.round(multiply(znach)));
            return line;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static double multiply(String[] arr){
        double res = 1;
        for (String i : arr){
            if (Integer.parseInt(i) != 0){
            res /= 1/(double) Integer.parseInt(i);
        }
            else return 0;
        }
        return res;
    }
    public String line_for_test(String line){
        return line;
    }
}

