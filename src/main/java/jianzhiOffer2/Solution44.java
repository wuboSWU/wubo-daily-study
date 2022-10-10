package jianzhiOffer2;

public class Solution44 {
    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        int i = 2;
        while (n - (Math.pow(10, i) - Math.pow(10, i - 1)) * i >= 0) {
            i++;
        }
        Double number = 10D;
        for (int j = 2; j < i; j++) {
            number = number + (Math.pow(10, j) - Math.pow(10, j - 1)) * j;
        }
        int pre = number.intValue();
        int cur = n - pre;
        int mid = cur / i;
        int index = cur % i;
        Double pow = Math.pow(10, i - 1);
        int x = pow.intValue();
        x = x + mid;
        String s = String.valueOf(x);
        char c = s.charAt(index);
        return c - '0';
    }

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.findNthDigit(11));
    }
}
