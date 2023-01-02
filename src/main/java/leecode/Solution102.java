package leecode;

import java.util.ArrayList;
import java.util.List;

public class Solution102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, null, null));
        new Solution102().levelOrder(root);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        iterate(res, root, 0);
        return res;
    }

    private void iterate(List<List<Integer>> res, TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        List<Integer> curList;
        if (cur + 1 <= res.size()) {
            curList = res.get(cur);
        } else {
            curList = new ArrayList<>();
            res.add(curList);
        }
        curList.add(root.val);
        cur++;
        if (root.left != null) {
            iterate(res, root.left, cur);
        }
        if (root.right != null) {
            iterate(res, root.right, cur);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
