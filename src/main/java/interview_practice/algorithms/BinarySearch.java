package interview_practice.algorithms;

import java.util.Scanner;

public class BinarySearch {
    static int[] arr = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};

    public static void main(String[] arg) {

        //System.out.println("Enter number to search...");
        //Scanner sc = new Scanner(System.in);
        int n = 110;

        int foundAtPosition = -1;

        int low = 0;
        int high = arr.length-1;

        System.out.println("low: "+low);
        while (low <= high) {

            int mid = (low + high) / 2;
            System.out.println("mid: "+mid);
            System.out.println("low: "+low);
            System.out.println("high: "+high);
            int elementAtMid = arr[mid];

            if(elementAtMid == n){
                foundAtPosition = mid;
                break;
            }else if(elementAtMid < n){
                low = mid+1;
            }else if(elementAtMid > n){
                high = mid-1;
            }
        }

        if(foundAtPosition == -1){
            System.out.println("Element not found!");
        }else{
            System.out.println("Found at position: "+foundAtPosition);
        }
    }

}
