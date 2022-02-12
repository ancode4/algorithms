package examples.amazondemo;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'foo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codeList
     *  2. STRING_ARRAY shoppingCart
     */

    public static int cartIndex = 0;

    public static int foo(List<String> codeList, List<String> shoppingCart) {
        // Write your code here

        for(String group : codeList) { //group -- ['apple' 'apple']
            if(cartIndex == shoppingCart.size())
                return 0;

            String[] groupItems = group.split(" ");
            for(String groupItem : groupItems) {
                System.out.println("groupItem: "+groupItem);
                System.out.println("cartIndex: "+cartIndex);
                System.out.println("itemAtCartIndex: "+shoppingCart.get(cartIndex));
                if(groupItem.equals("anything")){
                    cartIndex++;
                }else{
                    int found = findInCart(groupItem, shoppingCart, cartIndex);
                    if(found == -1){
                        return 0;
                    }else{
                        cartIndex = found+1;
                    }
                }
            }
        }

        return 1;
    }

    public static int findInCart(String groupItem, List<String> shoppingCart,
                                 int lastIndex){
        for(int i=lastIndex;i<shoppingCart.size();i++) {
            String item = shoppingCart.get(i);
            if(item.equals(groupItem)){
                return i;
            }
        }

        return -1;
    }

}

public class ShoppingCart {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int codeListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> codeList = IntStream.range(0, codeListCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int shoppingCartCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> shoppingCart = IntStream.range(0, shoppingCartCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result.foo(codeList, shoppingCart);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

