package Book5.chapter3;

import java.util.Scanner;

public class Factorial {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a number to get the factorial:");
        int n = sc.nextInt();
        long fact;
        fact = factorial(n);
//        System.out.println("The factorial of "+ n + " is " + fact + ".");
        System.out.println("#Recursive: The factorial of "+ n + " is " + recursiveFactorial(n) + ".");
    }

    private static long factorial(int n) {
        long f = 1;
        for (int i = 1; i <= n; i++)
            f = f * i;
        return f;
    }

    private static long recursiveFactorial(int n)
    {
        if (n == 1)
            return 1;
        else
            return n * recursiveFactorial(n-1);
    }


}
