package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 다섯_글자_넘는_경우() {
        List<String> carNames = Arrays.asList("다섯자이상의이름");
        assertThrows(IllegalArgumentException.class, () -> {
           InputValidator.validateCarNames(carNames);
        });
    }

    void 중간에_다섯글자_넘는_경우() {
        List<String> carNames = Arrays.asList("pobi","다섯글자넘는이름","jun");
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateCarNames(carNames);
        });
    }

    void 컴마_연속_두개() {
        List<String> carNames = Arrays.asList("pobi","","jun","aa");
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateCarNames(carNames);
        });
    }

    void 빈_문자열(){
        List<String> carNames = Arrays.asList("");
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateCarNames(carNames);
        });
    }

    void 컴마_빈칸_컴마(){
        List<String> carNames = Arrays.asList("pobi", " ", "jun");
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateCarNames(carNames);
        });
    }

    void 올바른_입력() {
        List<String> carNames = Arrays.asList("pobi", "jun", "aa");
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateCarNames(carNames);
        });
    }




}