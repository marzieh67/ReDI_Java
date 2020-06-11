package Java_1;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
    public static int fibonacci(int n){
        if (n==0) return 0;
        if (n==1) return 1;
        int result=fibonacci(n-1)+fibonacci(n-2);
        return result;
    }
}
