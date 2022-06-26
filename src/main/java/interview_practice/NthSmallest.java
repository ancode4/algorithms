package interview_practice;


import java.util.ArrayList;
import java.util.List;

public class NthSmallest {

    private static int[] inputArray = {5,2,2,5,7,6,8,9};

    public static void main(String[] arg) {
        int n = Integer.parseInt(arg[0]);

        //int[] outputArray = new int[n-1];
        List<Integer> output = new ArrayList<>();

        for(int j=0; j<n; j++) {
            int smallest = Integer.MAX_VALUE;
            int indexOfSmallest = -1;
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] != -1 && (inputArray[i] < smallest)) {
                    smallest = inputArray[i];
                    indexOfSmallest = i;
                }
            }
            if(!output.contains(smallest)) {
                output.add(smallest);
            }
            inputArray[indexOfSmallest] = -1;
        }

        System.out.println("The Nth smallest integer is: \n");
        System.out.println(output.get(output.size()-1));
    }
}