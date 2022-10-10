package jianzhiOffer2;

public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] numbers = {2, 2, 2, 0, 1};
        System.out.println(solution11.minArray(numbers));
    }

    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        if (numbers[0] < numbers[numbers.length - 1]) {
            return numbers[0];
        }
        for (int i = 0, j = 1; j < numbers.length; i++, j++) {
            if (numbers[i] > numbers[j]) {
                return numbers[j];
            }
        }
        return numbers[0];
    }
}
