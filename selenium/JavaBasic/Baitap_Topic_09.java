package JavaBasic;

public class Baitap_Topic_09 {
    public static void main(String[] args) {

        //Bài 1
        /*Scanner myobj = new Scanner(System.in);
        System.out.println("Nhập số n");
        int n= myobj.nextInt();
        System.out.println("n = " + n);
        System.out.println("Các số chia hết cho 2 là :");

            while (n <= 100) {
                if (n%2==0) {
                    System.out.print(n + " ");

                }
                n++;
            }*/

        //Bài 2
        /*Scanner myobj1 = new Scanner(System.in);
        System.out.println("Nhập số a");
        int a = myobj1.nextInt();
        System.out.println("a = " + a);
        System.out.println("Nhập số b");
        int b = myobj1.nextInt();
        System.out.println("a = " + b);
        System.out.println("Các số chia hết cho 3 và 5 là :");
        while (a < b) {
//
            if (a % 3 == 0 & a % 5 == 0) {
                System.out.print(a + " ");

            }
            a++;


        }*/

        //Bài 3


        /*Scanner myobj2 = new Scanner(System.in);
        System.out.println("Nhập số n1");
        int n1= myobj2.nextInt();
        System.out.println("n1 = " + n1);
        int i=0;
        int sum=0;
        while (i<n1){
            System.out.println(i);
            sum= sum +i;
            i++;
        }
        System.out.println(+sum);*/


        //Bài 4
        /*Scanner myobj1 = new Scanner(System.in);
        System.out.println("Nhập số a");
        int a = myobj1.nextInt();
        System.out.println("a = " + a);
        System.out.println("Nhập số b");
        int b = myobj1.nextInt();
        System.out.println("a = " + b);
        System.out.println("Các số chia hết cho 3 là :");
        while (a<b){
            if (a%3==0){
                System.out.print( a+ " ");
            }
            a++;
        }*/

        //Bài 5
        /*Scanner myobj3 = new Scanner(System.in);
        System.out.println("Nhập số n2");
        int n2 = myobj3.nextInt();
        System.out.println("n2 = " + n2);
        if (n2 < 0) {
            System.out.println("Giai thừa không xác định cho số âm.");
        } else if (n2 == 0) {
            // Giai thừa của 0 là 1
            System.out.println("Giai thừa của 0 là 1.");
        } else {
            int m1 = 1;
            int p = 1;

            do {
                System.out.println(m1);
                p *= m1;
                m1++;
            } while (m1 <= n2);
            System.out.println("Giai thừa : " + p);
        }*/

        //Bài 6
        int i=0;
        int sum=0;
        while (i<=10){
            if(i%2==0) {
                System.out.println(i);
            }
            sum = sum + i;
            i++;
        }
        System.out.println(+sum);






    }


}
