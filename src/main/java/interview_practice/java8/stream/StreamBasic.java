package interview_practice.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

/* STREAM OPERATORS
1. Intermediate operators
   map(), filter(), sorted()
2. Terminal operators
    collect(), reduce(), foreach()
 */
public class StreamBasic {
    private static final List<Integer> list = Arrays.asList(2,3,4,5,2);
    private static final List<Integer> list2 = Arrays.asList(8,1,1,1,8);
    /*public static void main(String[] args) {
        map();

        Optional<String> opt = Optional.ofNullable("Anish");
        opt.ifPresent(name -> System.out.println("Opt out: "+name));

        Optional<String> emp = Optional.empty();
        String supplied = emp.orElseGet(() -> {
            String greet = "Hi, ";
            return greet+"Its lonely here!";
        });
        System.out.println(supplied);
    }*/

    public static void main(String[] args) {
        flatMap();
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

    private static void flatMap() {
        List<List<Integer>> nestedList = new ArrayList<>();
        nestedList.add(list);
        nestedList.add(list2);
        List<Integer> mappedList = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println(nestedList);
        System.out.println(mappedList);
    }
}
