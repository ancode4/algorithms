package examples;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> resultList = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        for (Integer integer : a) {
            tempList.add(integer);
            Collections.sort(tempList);
            resultList.add(getMedian(tempList));
        }

        return resultList;
    }

    public static Double getMedian(List<Integer> list){
        int listSize = list.size();

        if(listSize % 2 == 0){
            //even
            int l = (listSize / 2)-1;
            int m = (listSize / 2);
            return (((double)list.get(l)+(double)list.get(m))/2.0);
        }else{
            return (double) (list.get(listSize / 2));
        }
    }

}

public class RunningMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(i -> String.format("%.1f",i))
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
