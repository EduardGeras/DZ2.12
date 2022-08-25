package com.example.dz2_12;

import com.example.dz2_12.exception.DivideByZeroException;
import com.example.dz2_12.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParameterizedCalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("paramsForPlus")
    public void plusTest(double a, double b, double actual) {
        assertThat(calculatorService.plus(a, b)).isEqualTo(actual);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest(double a, double b, double actual) {
        assertThat(calculatorService.minus(a, b)).isEqualTo(actual);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiply")
    public void multiplyTest(double a, double b, double actual) {
        assertThat(calculatorService.multiply(a, b)).isEqualTo(actual);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivide")
    public void divideTest(double a, double b, double actual) {
        if (b == 0) {
            assertThatExceptionOfType(DivideByZeroException.class)
                    .isThrownBy(()-> calculatorService.divide(a, b))
                    .withMessage("На нуль делить нельзя!!!");
        } else {
            assertThat(calculatorService.divide(a, b)).isEqualTo(actual);
        }
    }

    public static Stream<Arguments> paramsForPlus() {
        return Stream.of(
                Arguments.of(5, 6, 11.0),
                Arguments.of(-5, 6, 1.0),
                Arguments.of(-5, -6, -11.0),
                Arguments.of(5, -6, -1.0),
                Arguments.of(0, 0, 0.0)
        );
    }

    public static Stream<Arguments> paramsForMinus() {
        return Stream.of(
                Arguments.of(5, 6, -1.0),
                Arguments.of(-5, 6, -11.0),
                Arguments.of(-5, -6, 1.0),
                Arguments.of(5, -6, 11.0),
                Arguments.of(0, 0, 0.0)
        );
    }

    public static Stream<Arguments> paramsForMultiply() {
        return Stream.of(
                Arguments.of(5, 6, 30.0),
                Arguments.of(-5, 6, -30.0),
                Arguments.of(-5, -6, 30.0),
                Arguments.of(5, -6, -30.0),
                Arguments.of(0, 0, 0.0)
        );
    }

    public static Stream<Arguments> paramsForDivide() {
        return Stream.of(
                Arguments.of(30, 6, 5.0),
                Arguments.of(-30, 6, -5.0),
                Arguments.of(-30, -6, 5.0),
                Arguments.of(30, -6, -5.0)
        );
    }
}
