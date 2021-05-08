package com;
import java.util.Scanner;

public class Country
{
    //The string value takes the name of the country
    String name;
    //Once a new node is created ask the user for input for that node
    public Country()
    {
        //Scan user input and place into node
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please enter country name");
        name = sc1.next();



    }


    public class City
    {
        //The string value takes the name of the city
        String name;
        //Once a new node is created ask the user for input for that node
        public City()
        {
            //Scan user input and place into node
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Please enter city name");
            name = sc1.next();

        }
    }
}
