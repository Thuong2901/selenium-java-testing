package JavaBasic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Baitap_Topic_07 {
    public static void main(String[] args){
        //Bai 1
        //@Test
        int a=9;
        switch (a){
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
            default:
                System.out.println();
        }


        //Bai 2
        Scanner myObj= new Scanner(System.in);
        System.out.println(" Nhập số a1");
        float a1 = myObj.nextFloat();
        System.out.println("a1 = " + a1);
        System.out.println(" Nhập số a2");
        float a2 = myObj.nextFloat();
        System.out.println("a2 = " + a2);
        System.out.println(" Nhập phép toán");
        char op = myObj.next().charAt(0);
        System.out.println("phép toán : " + op);

        switch (op){
            case '+':
                System.out.println("Tổng là : " + (a1 + a2 ));
                break;
            case '-':
                System.out.println("Hiệu là : " + (a1 - a2 ));
                break;
            case '*':
                System.out.println("Tích là : " + (a1 * a2 ));
                break;
            case '/':
                System.out.println("Thương là : " + (a1 / a2 ));
                break;
            case '%':
                System.out.println("% là : " + (a1 % a2 ));
                break;
            default:
                System.out.println("...");
        }


        //Bai 3
       /* int a=17;
        switch (a) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng này có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng này có 30 ngày");
                break;
            case 2:
                System.out.println("Tháng này có 28 hoặc 29 ngày");
                break;
            default:
                System.out.println("Không có tháng này");
        }*/
    }

}
