package examples.amazondemo;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class SSResult {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static final int numberofsuggestions = 3;

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here
        List<List<String>> output = new ArrayList<>();
        int querySize = customerQuery != null ? customerQuery.length() : 0;
        System.out.println("QuerySize: "+querySize);
        if(querySize >= 2) {
            for(int i=2; i<=querySize; i++){
                String substr = customerQuery.substring(0, i);
                List<String> suggestionList = getSuggestionForSubquery(substr, repository);
                output.add(suggestionList);
            }
        }

        return output;
    }

    public static List<String> getSuggestionForSubquery(String subquery,List<String> repository) {
        List<String> suggestions = new ArrayList<>();

        int subquerysize = subquery.length();

        for(String s : repository){

            if(s.length() >= subquerysize) {
                String substr = s.substring(0, subquerysize);
                if(substr.equalsIgnoreCase(subquery)) {
                    suggestions.add(s);
                }
            }
        }

        Collections.sort(suggestions);
        if(suggestions.size() > numberofsuggestions) {
            suggestions = suggestions.subList(0, numberofsuggestions);
        }

        return suggestions;
    }
}

public class SearchSuggestions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int repositoryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> repository = IntStream.range(0, repositoryCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String customerQuery = bufferedReader.readLine();

        List<List<String>> result = SSResult.searchSuggestions(repository, customerQuery);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
