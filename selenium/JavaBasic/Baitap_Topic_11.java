package JavaBasic;

public class Baitap_Topic_11 {
    public static void main(String[] args){
        /*int [] myArr= {6,42,3,7};
        for (int x=0; x<myArr.length;x++){
            System.out.println(myArr[x]);
        }

        int[] points = {6,42,3,7};
        for (int point :points){
            System.out.println(point);
        }

        List<String> names = Arrays.asList("A","B","C");
        for (String name :names){
            System.out.println("Name :" + name);
        }

        int[] years = new int[] {1997,20000,20005,2023};
        List<int[]>yearList = Arrays.asList(years);
        for (int[] year: yearList){
            for (int i:year){
                System.out.println(i);
            }

        }*/


        //Bài 1
       /* List<Integer> numbers = Arrays.asList(1,60,4,78,40);
        int maxnumber = Collections.max(numbers);
        System.out.println("Số lớn nhất của dãy là :" + maxnumber);*/

        //Bài 2
        /*int numbers1[] = {2,4,5,6,4,200};
        int first = numbers1[0];
        int last = numbers1[numbers1.length - 1];
        System.out.println("Số đầu tiên của chuỗi là :" + first);
        System.out.println("Số cuối cùng của chuỗi là :" + last);*/

        /*List<Integer> numbers = Arrays.asList(1,60,4,78,40);
        int first = numbers.getFirst();
        int last = numbers.getLast();
        int sum =0;
        sum = first+ last;
        System.out.println(sum);*/


        //Bài 3

        String chuoi = "1234567890";

        /*// Chuyển chuỗi thành mảng các ký tự
        char[] mangKytu = ();
        System.out.println(mangKytu);
        // In các số chẵn
        for (char kytu : mangKytu) {
            if (Character.isDigit(kytu)) { // Kiểm tra xem ký tự có phải là số hay không
                int so = Character.getNumericValue(kytu);
                if (so % 2 == 0) {
                    System.out.print(so + " ");
                }
            }
        }
        System.out.println(); // Xuất dòng mới

        /*List<Integer> numbers = Arrays.asList(1,60,4,78,40,5,3,4,76,44);
        for (List<Integer> kytu1 :Arrays.asList(numbers) ){
            int a = Character.getNumericValue(List<Integer> kytu1);



        }*/

        //Bài7
        /*Scanner myObj = new Scanner(System.in);
        System.out.println(" Nhập ID");
        int ID = myObj.nextInt();
        System.out.println(" Nhập tên học sinh");
        String Name = myObj.next();
        System.out.println(" Nhập tuổi của học sinh");
        int Age = myObj.nextInt();
        System.out.println(" Nhập điểm của học sinh");
        int Score = myObj.nextInt();
        System.out.println(ID + " "+ Name+ " "+  Age+ " " + Score);*/






    }

}
