package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {

    private final static int MAX_INPUT_SIZE = 10000;
    private final static int MIN_INPUT_SIZE = 1;
    private final static int MAX_EMAIL_LENGTH = 19;
    private final static int MIN_EMAIL_LENGTH = 11;
    private final static int MAX_NICKNAME_LENGTH = 19;
    private final static int MIN_NICKNAME_LENGTH = 1;
    private final static String DOMAIN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        validateLength(forms);

        List<String> answer = List.of("answer");
        return answer;
    }

    private static void validateLength(List<List<String>> input) {
        int inputSize = input.size();
        if (inputSize < MIN_INPUT_SIZE || inputSize > MAX_INPUT_SIZE) {
            throw new IllegalArgumentException("닉네임 신청은 1명에서 10000명까지만 가능합니다.");
        }
    }

    private static void validateEmail(String email) {
        int emailLength = email.length();
        if (emailLength < MIN_EMAIL_LENGTH || emailLength > MAX_EMAIL_LENGTH) {
            throw new IllegalArgumentException("이메일 전체 길이는 11자 이상 20자 미만입니다.");
        }

        String pattern = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@" + DOMAIN;
        boolean regex = Pattern.matches(pattern, email);
        if (!regex) {
            throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
        }
    }

    private static void validateNickName(String nickName) {
        int nickNameLength = nickName.length();
        if (nickNameLength < MIN_NICKNAME_LENGTH || nickNameLength > MAX_NICKNAME_LENGTH) {
            throw new IllegalArgumentException("닉네임 전체 길이는 1자 이상 20자 미만입니다.");
        }

        String pattern = "^[가-힣]*$";
        boolean regex = Pattern.matches(pattern, nickName);
        if (!regex) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }
    }
}
