import java.util.Arrays;

public class ProblemSet13 {

    public boolean groupSum(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start > numbers.length - 1) {
            return false;
        }
        if (groupSum(start + 1, numbers, target - numbers[start])) {
            return true;
        }
        return groupSum(start + 1, numbers, target);
    }

    public boolean groupSum6(int start, int[] numbers, int target) {
        if (start == numbers.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (numbers[start] == 6) {
            return groupSum6(start + 1, numbers, target - numbers[start]);
        }
        if (groupSum6(start + 1, numbers, target - numbers[start])) {
            return true;
        }
        return groupSum6(start + 1, numbers, target);
    }

    public boolean groupNoAdj(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start >= numbers.length) {
            return false;
        }
        if (groupNoAdj(start + 2, numbers, target - numbers[start])) {
            return true;
        }
        return groupNoAdj(start + 1, numbers, target);
    }

    public boolean groupSum5(int start, int[] numbers, int target) {
        if (start >= numbers.length) {
            if (target == 0) {
                return  true;
            }
            return false;
        }
        if (numbers[start] % 5 == 0) {
            if (start < numbers.length - 1 && numbers[start + 1] == 1) {
                return groupSum5(start + 2, numbers, target - numbers[start]);
            }
            return groupSum5(start + 1, numbers, target - numbers[start]);
        }
        if (groupSum5(start + 1, numbers, target - numbers[start])){
            return true;
        }
        return groupSum5(start + 1, numbers, target);
    }

    public boolean groupSumClump(int start, int[] numbers, int target) {
        if (start >= numbers.length) {
            return target == 0;
        }
        int i = start;
        int sum = 0;

        while (i < numbers.length && numbers[start] == numbers[i]) {
            sum += numbers[i];
            i++;
        }

        if (groupSumClump(i, numbers, target - sum)) {
            return true;
        }
        if (groupSumClump(i, numbers, target)) {
            return true;
        }
        return false;
    }

    public boolean splitArray(int[] numbers) {
        return splitArrayHelper(0, numbers, 0, 0);
    }
    private boolean splitArrayHelper(int start, int[] numbers, int sec1, int sec2) {
        if(start >= numbers.length) {
            return sec1 == sec2;
        }
        if (splitArrayHelper(start + 1, numbers, sec1 + numbers[start], sec2)) {
            return true;
        }
        if (splitArrayHelper(start + 1, numbers, sec1, sec2 + numbers[start])) {
            return true;
        }
        return false;
    }
    public boolean splitOdd(int[] numbers) {
        return splitOddHelper(numbers, 0,0,0);
    }
    private boolean splitOddHelper(int[] numbers, int i, int sec1, int sec2) {
        if (i == numbers.length) {
            boolean temp = sec1 % 2 == 1 && sec2 % 10 == 0 || sec2 % 2 == 1 && sec1 % 10 == 0;
            return temp;
        }
        if (splitOddHelper(numbers, i + 1, sec1 + numbers[i], sec2)) {
            return true;
        }
        return splitOddHelper(numbers, i + 1, sec1, sec2 + numbers[i]);
    }
}
