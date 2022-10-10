package jianzhiOffer2;

public class Solution43 {
    public int countDigitOne(int n) {
        String number = String.valueOf(n);
        int length = number.length();
        int temp = 0;
        for (int i = 0; i < length; i++) {
            if (number.charAt(i) >= '1') {
                temp++;
            }
        }
        int total = 0;
        for (int i = 1; i <= temp; i++) {
            int y = 1;
            for (int j = 0; j < i; j++) {
                y = y * (temp - j);
            }
            int x = 1;
            for (int j = 1; j <= i; j++) {
                x = x * j;
            }
            total = total + y * i / x;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.countDigitOne(12));
    }
}
