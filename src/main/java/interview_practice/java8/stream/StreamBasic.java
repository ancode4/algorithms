package interview_practice.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* STREAM OPERATORS
1. Intermediate operators
   map(), filter(), sorted()
2. Terminal operators
    collect(), reduce(), foreach()
 */
public class StreamBasic {
    private static final List<Integer> list = Arrays.asList(2,3,4,5,2);
    public static void main(String[] args) {
        foreach();
    }

    // foreach -> terminal operator - void function loops over each list item
    private static void foreach() {
        list.stream().filter(x->x%2==0).forEach(filteredValue -> {String s = "FilteredValue: "+filteredValue; System.out.println(s);});
    }

    // reduce - terminal operator - function performs operations on each list item collectively and returns single value
    private static void reduce() {
        int even = list.stream().filter(x->x%2==0).reduce(0, Integer::sum);

        System.out.println(even);
    }

    // filter - intermediate operator - function returns boolean which determines whether or not to filter list item
    private static void filter() {
        List<Integer> filteredList = list.stream().filter(x->x%2==0).collect(Collectors.toList());

        System.out.println(filteredList);
    }

    // map - intermediate operator - function performs operations on each list item and returns value for each list item.
    private static void map() {
        List<String> mappedList = list.stream()
                .map(n -> "Number"+n)
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(mappedList);
    }
}
