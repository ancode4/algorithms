package dsa_examples.amazontest;

import java.util.Scanner;

public class IntToLongProblem {

    public static long mod = 1000000007L;

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        long totalPower = 0;

        int power = 2147483647;

        for(int i=0;i<t;i++){
            totalPower+=power;
            System.out.println("TotalP: "+totalPower);
            int m = (int) (totalPower % mod);

            System.out.println("M: "+m);
        }
    }
}
