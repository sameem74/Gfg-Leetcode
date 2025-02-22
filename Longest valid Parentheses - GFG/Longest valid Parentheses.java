//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> st = new Stack();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'&& st.size()>1 && s.charAt(st.peek())=='('){
                st.pop();
            }
            else {
                st.push(i);
            }
        }
        int limit = s.length(), result=0;
        while(!st.isEmpty()){
            int p = st.pop();
            result=Math.max(result, limit-p-1);
            limit=p;
        }
        return result;
    }
}