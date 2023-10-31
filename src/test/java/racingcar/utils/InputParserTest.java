package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 하나의_값_만_들어올_때() {
        assertParsedNames("pobi", "pobi");
    }

    @Test
    void 여러_정상_값이_있을_때() {
        assertParsedNames("pobi,woni,jun", "pobi", "woni", "jun");
    }

    @Test
    void 빈_문자열_이_들어올_때() {
        assertParsedNames("", "");
    }

    @Test
    void 첫_시작이_컴마일_때() {
        assertParsedNames(",pobi,jun", "", "pobi", "jun");
    }

    @Test
    void 연속_컴마가_들어올_때() {
        assertParsedNames("pobi,,jun,aa", "pobi", "", "jun", "aa");
    }

    @Test
    void 띄어쓰기가_들어올때() {
        assertParsedNames("pobi, ,jun", "pobi", " ", "jun");
    }

    private void assertParsedNames(String input, String... expectedNames) {
        List<String> result = InputParser.parseCarNames(input);
        assertThat(result).containsExactly(expectedNames);
    }
}