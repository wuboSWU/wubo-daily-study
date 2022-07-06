package leecode;

import java.util.*;

public class Solution55 {
    private static int[] nums = {2, 3, 1, 1, 4};

    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        return jump(0, nums, map);
    }

    private boolean jump(int index, int[] nums, Map<Integer, Boolean> map) {
        if (map.get(index) != null) {
            return false;
        }
        int jumpLength = nums[index];
        if (index == nums.length - 1 || index + jumpLength >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i <= jumpLength; i++) {
            if (jump(index + i, nums, map)) {
                return true;
            }
        }
        map.put(index, false);
        return false;
    }

    /**
     * 方法二
     *
     * @param nums
     * @return
     */
    private boolean jump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] isGoal = new boolean[nums.length];
        isGoal[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (isGoal[i + j]) {
                    if (i == 0) {
                        return true;
                    }
                    isGoal[i] = true;
                    break;
                }
            }
        }
        return false;
    }

    public boolean canJump3(int[] nums) {
        int curIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[curIndex] <= 0) {
                break;
            }
            if (nums[curIndex] - (i - curIndex) <= nums[i]) {
                curIndex = i;
            }
        }
        return curIndex + nums[curIndex] >= nums.length - 1;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump3(nums));
    }
}
