package onboarding;

import java.util.List;

class Problem1 {
    private final static int exception = -1;
    private final static int SAME_SCORE = 0;
    private final static int POBI_WIN = 1;
    private final static int CRONG_WIN = 2;
    private final static int INPUT_SIZE = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!validateLength(pobi) || !validateRange(pobi) || !validateSequence(pobi)) {
            return exception;
        }
        if (!validateLength(crong) || !validateRange(crong) || !validateSequence(crong)) {
            return exception;
        }
        return answer;
    }

    private static int getMyScore(List<Integer> player) {
        int result1 = getMaxScore(addAllNumbers(player.get(0)), multiplyAllNumbers(player.get(0)));
        int result2 = getMaxScore(addAllNumbers(player.get(0)), multiplyAllNumbers(player.get(0)));
        return getMaxScore(result1, result2);
    }

    private static int addAllNumbers(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    private static int multiplyAllNumbers(int number) {
        int result = 1;
        while (number > 0) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    private static int getMaxScore(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }

    private static boolean validateLength(List<Integer> input) {
        if (input.size() != INPUT_SIZE) {
            return false;
        }
        return true;
    }

    private static boolean validateRange(List<Integer> input) {
        if (input.get(0) < 1 && input.get(1) > 400) {
            return false;
        }
        return true;
    }

    private static boolean validateSequence(List<Integer> input) {
        if (input.get(0) % 2 != 1) {
            return false;
        } else if (input.get(1) % 2 != 0) {
            return false;
        } else if (input.get(1) - input.get(0) != 1) {
            return false;
        }
        return true;
    }
}