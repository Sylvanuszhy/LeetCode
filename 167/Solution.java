class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while (i<j) {
            int sum = numbers[i]+numbers[j];
            if (sum<target)
                i++;
            else if (sum>target)
                j--;
            else
                break;
        }
        int[] res = {i+1, j+1};
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] res = twoSum(nums, 13);
        System.out.print(res[0]);
        System.out.print(res[1]);
    }
}
