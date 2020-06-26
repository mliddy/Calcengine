package com.mliddy.errorhandling;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = null;
        int total = 0;



        try {


            reader = new BufferedReader(new FileReader("C:\\Users\\mauriceliddy\\Documents\\numbers.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                total += Integer.valueOf(line);
                System.out.println("Total is : " + total);
            }

        } catch(Exception e){
            System.out.println("Error found: "+ e.getMessage());
        }
        finally {
            try {
                if (reader != null)
                    reader.close();
                System.out.println("Final answer is: " + total);
            }
            catch(Exception e){
                System.out.println("Error closing file: "+ e.getMessage());
            }

        }

        }

}
