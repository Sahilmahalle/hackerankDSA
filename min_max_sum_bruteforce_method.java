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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    int leftSum[]=new int[arr.size()];
    int rightSum[]=new int[arr.size()];
    int sum[]=new int[arr.size()];
    // leftSum[0]=0;
    // rightSum[arr.size()-1]=0;
    int max=0;
    int min=0;
    
    for(int i=1;i<arr.size();i++){
        leftSum[i]=arr.get(i-1)+leftSum[i-1];
        
        for(int j=arr.size()-2;j>=0;j--){
            rightSum[j]=arr.get(j+1)+rightSum[j+1];
        }
    }
    for(int i=0;i<arr.size();i++){
        sum[i]=leftSum[i]+rightSum[i];
    }
    
    for(int i=0;i<sum.length;i++){
        
        if(max<sum[i]){
            max=sum[i];
        }
        min=max;
        if(min>sum[i]){
            min=sum[i];
        }
        
    }System.out.print(min+" "+max);
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
