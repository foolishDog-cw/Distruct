package day02;

/**
 * @author Tedu
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(f(4));
        System.out.println(fb(4));
    }
    public static int f(int n){
        if (n==1){
            return 1;
        }
        return n*f(n-1);
    }
    /*计算斐波那契数列第n位的值 注:斐波那契数列是一组数，从第三位开始，每一位是其前两位数相加  */
    public static int fb(int n){
        if (n==1 || n==2){
            return 1;
        }
        return fb(n-2)+fb(n-1);
    }
}
