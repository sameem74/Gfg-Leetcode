//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int xor_=0,ans=0;
        HashMap<Integer,Integer> mm = new HashMap<>();
        for(int x:arr){
            xor_^=x;
            if(xor_==k)ans++;
            ans+=mm.getOrDefault(xor_^k,0);
            mm.put(xor_,mm.getOrDefault(xor_,0)+1);
        }
        return ans;
    }
}