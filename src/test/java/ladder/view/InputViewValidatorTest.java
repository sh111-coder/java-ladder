package ladder.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {10001, 20000, 30000, 10000000})
    @DisplayName("참여자의 수가 10000명을 넘으면 예외를 던진다.")
    void exceedMaxPlayerCountTest(int maxPlayerCount) {

        assertThatThrownBy(() -> InputViewValidator.validateNamesCount(maxPlayerCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 참여자의 수는 10000명 이하여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "##", "#a", "가나다", "a1"})
    @DisplayName("사다리의 높이는 숫자여아한다.")
    void isLadderHeightNumericTest(String ladderHeight) {

        assertThatThrownBy(() -> InputViewValidator.validateNumeric(ladderHeight))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 숫자만 입력해야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi.crong.jk", "pobi&crong&jk", "pobi:crong:jk"})
    @DisplayName("참여자 이름들의 구분자가 ','가 아니면 예외를 던진다.")
    void isPlayerNamesDelimiterWrongTest(String playerNames) {

        assertThatThrownBy(() -> InputViewValidator.validateReadPlayerNames(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여자 이름은 ','로 구분되어야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝.5000.꽝", "꽝&5000&꽝", "꽝:5000:꽝"})
    @DisplayName("실행 결과의 구분자가 ','가 아니면 예외를 던진다.")
    void isRunResultsDelimiterWrongTest(String runResult) {

        assertThatThrownBy(() -> InputViewValidator.validateReadRunResults(runResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 결과는 ','로 구분되어야합니다.");
    }

}
