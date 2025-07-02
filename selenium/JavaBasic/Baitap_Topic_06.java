package JavaBasic;

import java.util.Scanner;

public class Baitap_Topic_06 {
    public static void main(String[] args) {

        //Bài 1
        /*Scanner myObj = new Scanner(System.in);
        System.out.println("Nhập a");
        int a = myObj.nextInt();
        if (a %2 ==0){
            System.out.println("a là số chẵn");

        }else {
            System.out.println("a là số lẻ");
        }


        //Bài 2
        Scanner  myObj1= new Scanner(System.in);
        System.out.println("Nhập a1");
        int a1 = myObj1.nextInt();
        System.out.println("a1: " + a1);
        System.out.println("Nhập b1");
        int b1 = myObj1.nextInt();
        System.out.println("b1: " + b1);
        if (a1 >= b1) {
            System.out.println("a1 lớn hơn hoặc bằng b1");
        } else {
            System.out.println("a1 nhỏ hơn b1");

        }*/

        //Bài 3

     /*   Scanner  myObj2= new Scanner(System.in);
        System.out.println(" Nhập tên của a2");
        String a2 = myObj2.nextLine();
        System.out.println("Tên a2 là : " + a2);
        System.out.println("Nhập tên của b2");
        String b2 = myObj2.nextLine();
        System.out.println("Tên b2 là: " + b2);
        if (Objects.equals(a2, b2)) {
            System.out.println("2 người cùng tên");
        } else {
            System.out.println("2 người khác tên");

        }*/

        //Bài 4
        /*Scanner  myObj3= new Scanner(System.in);
        System.out.println(" Nhập a3");
        int a3 = myObj3.nextInt();
        System.out.println("a3 = " + a3);
        System.out.println("Nhập b3");
        int b3 = myObj3.nextInt();
        System.out.println("b3 = " + b3);
        System.out.println("Nhập c3");
        int c3 = myObj3.nextInt();
        System.out.println("c3 = " + c3);
        float d3= Math.max(Math.max(a3,b3),c3);
        System.out.println("Số lớn nhất là :" + d3);*/

        //Bài 5
        /*Scanner  myObj4= new Scanner(System.in);
        System.out.println(" Nhập a4");
        int a4 = myObj4.nextInt();
        System.out.println("a4 = " + a4);
        if (a4>=10 && a4<=100){
            System.out.println("a4 nằm trong [10,100]");
        }else {
            System.out.println("a4 không nằm trong [10,100]");
        }*/

        //Bai 6
       /* Scanner  myObj5= new Scanner(System.in);
        System.out.println(" Nhập điểm của sv a5");
        float a5 = myObj5.nextFloat();
        System.out.println("Điểm của sv a5 là : " + a5);
        if (a5>0 && a5<5){
            System.out.println("Điểm của sv a5 là D");
        } else if (a5>=5 && a5 < 7.5) {
            System.out.println("Điểm của sv a5 là C");
        } else if (a5>=7.5 && a5<8.5) {
            System.out.println("Điểm của sv a5 là B");
        } else if (a5>=8.5 && a5<=10) {
            System.out.println("Điểm của sv a5 là A");
        }*/

        //Bai 7
        Scanner  myObj6= new Scanner(System.in);
        System.out.println(" Nhập tháng");
        int a6 = myObj6.nextInt();
        System.out.println("Tháng: " + a6);
        if (a6==1||a6==3||a6==5||a6==7||a6==8||a6==10||a6==12){
            System.out.println("Tháng" + a6 + " có 31 ngày");
        } else if (a6==4||a6==6||a6==9||a6==11) {
            System.out.println("Tháng" + a6 + " có 30 ngày");
        } else if (a6==2) {
            System.out.println("Tháng" + a6 + " có 28 hoặc 29 ngày");

        }
    }

}
