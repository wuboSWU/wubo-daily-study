package jianzhiOffer2;

import java.util.Arrays;

public class Solution33 {
    public static void main(String[] args) {
        int[] postOrder = {1, 3, 2, 6, 5};
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.verifyPostorder(postOrder));
    }

    public boolean verifyPostorder(int[] postorder) {
        int left = 0;
        int right = postorder.length - 1;
        return ifExist(postorder, left, right);
    }

    //时间复杂度O(n^2)
    private boolean ifExist(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int head = postorder[right];
        int mid = -1;
        //找到第一个比根节点大的，划分左右子树
        for (int i = left; i < right; i++) {
            if (postorder[i] > head) {
                mid = i;
                break;
            }
        }
        if (mid == -1) {
            return ifExist(postorder, left, right - 1);
        }
        for (int i = left; i < mid; i++) {
            if (postorder[i] > head) {
                return false;
            }
        }
        for (int i = mid; i < right; i++) {
            if (postorder[i] < head) {
                return false;
            }
        }
        return ifExist(postorder, left, mid) && ifExist(postorder, mid, right - 1);
    }
}
