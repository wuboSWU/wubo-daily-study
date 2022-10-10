package jianzhiOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int i = 0;
        int j = 0;
        int[] res = new int[matrix.length * matrix[0].length];
        int num = -1;
        boolean flag = true;
        while (matrix[i][j] != Integer.MAX_VALUE) {
            num++;
            res[num] = matrix[i][j];
            matrix[i][j] = Integer.MAX_VALUE;
            if (flag && j + 1 < matrix[0].length && matrix[i][j + 1] != Integer.MAX_VALUE) {
                j = j + 1;
                continue;
            }
            if (i + 1 < matrix.length && matrix[i + 1][j] != Integer.MAX_VALUE) {
                i = i + 1;
                continue;
            }
            if (j - 1 >= 0 && matrix[i][j - 1] != Integer.MAX_VALUE) {
                j = j - 1;
                continue;
            }
            if (i - 1 >= 0 && matrix[i - 1][j] != Integer.MAX_VALUE) {
                flag = false;
                i = i - 1;
                continue;
            }
            flag = true;
            if (j + 1 < matrix[0].length) {
                j = j + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(matrix.length);

        Solution29 solution29 = new Solution29();
        int[] ints = solution29.spiralOrder(matrix);
        System.out.println(Arrays.toString(ints));
    }

}
