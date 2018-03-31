/**
 * Created by Juliana on 27/04/2017.
 */
public class main {
    public static int cuadrado(int x){
        return x*x;
    }
    public static void main(String[]args){
        int a=10;
        int b=15;
        int c= 4;
        int res = a+(cuadrado(c)-b);
        System.out.println(res);
    }
}
