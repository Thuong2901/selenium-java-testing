package JavaBasic;

public class Topic_03_And_Or {
    public static void main(String[] args){
        boolean a;
        boolean b;
        boolean c;
         a =true;
         b = true;
         c = a && b;
        System.out.println("A and B =" + c);
        a= false;
        b= true;
        c = a && b;
        System.out.println("A and B = " + c);

        a= false;
        b= true;
        c = a || b;
        System.out.println("A or B = " + c);
    }
}
