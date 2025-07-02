package JavaBasic;

import java.util.Scanner;

public class Baitap_Topic_04 {
    public static void main(String[] args) {

        //Bài 1
        int P1 = 28;
        int P2;
        P2 = P1 + 15;
        System.out.println("After 15 years, age Thuong will be " + P2);

        //Bài 2
        int a = 5;
        int b = 6;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);

        //Bài 3

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("a1");
        int a1 = myObj.nextInt();
        System.out.println("a1: " + a1);  // Output user input
        System.out.println("b1");
        int b1 = myObj.nextInt();  // Read user input
        System.out.println("b1: " + b1);
        if (a1 > b1) {
            System.out.println("True");
        } else {
            System.out.println("False");

        }


    }

}
