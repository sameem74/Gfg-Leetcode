class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

    int l = 0;
    int r = nums[nums.length - 1] - nums[0];

    while (l < r) {
      final int m = (l + r) / 2;
      if (numPairDistancesNoGreaterThan(nums, m) >= k)
        r = m;
      else
        l = m + 1;
    }

    return l;
  }

  private int numPairDistancesNoGreaterThan(int[] nums, int m) {
    int count = 0;
    int j = 1;
    
    for (int i = 0; i < nums.length; ++i) {
      while (j < nums.length && nums[j] <= nums[i] + m)
        ++j;
      count += j - i - 1;
    }
    return count;
    }
}