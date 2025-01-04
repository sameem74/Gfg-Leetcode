//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
         int ans = 0, size = arr.length;
        for (int i = 0; i < size - 2; i++) {
            int j = i + 1, k = size - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                }   
                else {
                    if (arr[j] == arr[k]) {
                        int count = k - j + 1;
                        ans += (count * (count - 1)) / 2;
                        break;
                    }
                    int countJ = 1, countK = 1;
                    while (j + 1 < k && arr[j] == arr[j + 1]) {
                        countJ++;
                        j++;
                    }
                    while (k - 1 > j && arr[k] == arr[k - 1]) {
                        countK++;
                        k--;
                    }
                    ans += countJ * countK;
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}