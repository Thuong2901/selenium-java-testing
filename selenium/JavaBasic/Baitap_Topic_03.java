package JavaBasic;

public class Baitap_Topic_03 {


    int number;
    public static void main(String[] args) {

        //1. Viết chương trình tạo ra 2 biến a, b....
        int a = 6;
        int b = 2;
        int P1 = a +b ;
        int P2= a - b;
        int P3 = a * b ;
        int P4 = a /b;
        System.out.println("Bài 1");
        System.out.println("a + b = " + P1 );
        System.out.println("a - b = " + (a-b) );
        System.out.println("a * b = " + P3 );
        System.out.println("a / b = " + P4 );

        //Tính diện tích HCN
        float chieudai= 7.5f;
        float chieurong = 3.8f;
        float P = chieudai *chieurong;
        System.out.println("Bài 2");
        System.out.println("Area= " + P);

//Bài 3
        String name = "Automation Testing";
        System.out.println("Bài 3");
        System.out.println("Hello " + name);

        //Bài 1
        int a1 = 5;
        int b1 = 6;
        a1 = a1 + b1;

        System.out.println("a = " + (a1 - b1));
        System.out.println("b = " + (a1 - b1));
    }



}
