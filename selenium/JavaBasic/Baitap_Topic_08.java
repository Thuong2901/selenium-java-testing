package JavaBasic;

import java.util.Scanner;

public class Baitap_Topic_08 {
    public static void main(String[] args) {
        //Bài 1:ok
       /* Scanner myObj= new Scanner(System.in);
        System.out.println(" Nhập số a");
        int a = myObj.nextInt();
        System.out.println("a1 = " + a);
        for (int i= 1;i<=a;){
          System.out.print(i++ + " " );
        }*/

        //Bài 2:ok
       /* Scanner myObj = new Scanner(System.in);
        System.out.println(" Nhập số a");
        int a1 = myObj.nextInt();
        System.out.println("a1 = " + a1);
        System.out.println(" Nhập số a");
        int b1 = myObj.nextInt();
        System.out.println("a1 = " + b1);
        for (int i; a1 <= b1; ) {
            System.out.print(a1++ + " ");
        }*/


        //Bài 3:ok

            /*int[] str = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int sum =0;
            for (int i = 0; i < str.length; i++) {
                if (str[i]%2 ==0) {
                sum += str[i];
                //System.out.print(str[i]);
            }
            }
        System.out.println(+sum);*/

        //Bai 4
        Scanner myObj = new Scanner(System.in);
        System.out.println(" Nhập số a");
        int a2 = myObj.nextInt();
        System.out.println("a2 = " + a2);
        System.out.println(" Nhập số a");
        int b2 = myObj.nextInt();
        System.out.println("b2 = " + b2);
        for (int i;a2<=b2;) {
            System.out.print( a2++ );
        }



        //Bai 5:ok
        /*Scanner myObj1 = new Scanner(System.in);
        System.out.println(" Nhập số n");
        int n = myObj1.nextInt();
        System.out.println("số nguyên n = " + n);
        //chuyển số nguyên thành chuỗi ký tự
        String str = Integer.toString(n);
        int sum =0;
        for (int i = 0; i < str.length(); i++) {
        //chuyển ký tự thành số nguyên
            int t1 = Integer.parseInt(Character.toString(str.charAt(i)));

            if (t1 % 2 != 0) {
                sum += t1;
                System.out.println(t1);
            }

        }
        System.out.println("Tổng số lẻ là :" + sum);*/

        //Bai 6
        Scanner myObj3 = new Scanner(System.in);
        System.out.println(" Nhập số a3");
        int a3 = myObj3.nextInt();
        System.out.println("a3 = " + a3);
        System.out.println(" Nhập số b3");
        int b3 = myObj3.nextInt();
        System.out.println("b3 = " + b3);
        for (int i = 0;a3<=b3;){
            System.out.print(a3++);
            if (a3 % 3==0){
                a3++;

            }
            System.out.println(a3);
        }


        //Bai 7 : ok
       /* Scanner myObj5 = new Scanner(System.in);
        System.out.println(" Nhập số m");
        int m = myObj5.nextInt();
        System.out.println("số nguyên m = " + m);
        int p=1;
        for (int i=1;i<= m;i++){
            p*=i;
        }
        System.out.println(+m + "! bằng =" + p);*/

    }
}
