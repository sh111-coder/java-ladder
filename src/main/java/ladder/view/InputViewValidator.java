package ladder.view;

public class InputViewValidator {

    private static final int MAX_NAMES_COUNT = 10000;
    private static final int MIN_NAMES_COUNT = 1;
    private static final String PLAYER_NAMES_SPLIT_DELIMITER = ",";

    private static final String NAMES_MAX_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참여자의 수는 10000명 이하여야합니다.";
    private static final String NAMES_MIN_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참여자의 수는 10000명 이하여야합니다.";
    private static final String NONE_NUMERIC_EXCEPTION_MESSAGE = "[ERROR] 숫자만 입력해야합니다.";
    private static final String PLAYER_NAMES_IS_WRONG_SPLIT_DELIMITER_EXCEPTION_MESSAGE = "[ERROR] 참여자 이름은 ','로 구분되어야합니다.";

    public static void validateNamesCount(final int count) {
        if (count > MAX_NAMES_COUNT) {
            throw new IllegalArgumentException(NAMES_MAX_COUNT_EXCEPTION_MESSAGE);
        }

        if (count < MIN_NAMES_COUNT) {
            throw new IllegalArgumentException(NAMES_MIN_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NONE_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    public static void validateReadPlayerNames(String playerNames) {
        if (isPlayerNamesSplitDelimiterWrong(playerNames)) {
            throw new IllegalArgumentException(PLAYER_NAMES_IS_WRONG_SPLIT_DELIMITER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isPlayerNamesSplitDelimiterWrong(String playerNames) {
        return !playerNames.contains(PLAYER_NAMES_SPLIT_DELIMITER);
    }
}
