package com;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main()
    {
        Main.DoublyLinkedList list = new Main.DoublyLinkedList();
        //exact code from country
        String countryName;
        Scanner sc1 = new Scanner("France");
        System.out.println("Please enter country name");
        countryName = sc1.next();

        //exact code from city
        String cityName;
        Scanner sc2 = new Scanner("Paris");
        System.out.println("Please enter city name");
        cityName = sc2.next();

        assertEquals("France",countryName);
        assertEquals("Paris", cityName);

    }


}