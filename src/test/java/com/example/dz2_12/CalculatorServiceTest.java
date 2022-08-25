package com.example.dz2_12;

import com.example.dz2_12.exception.DivideByZeroException;
import com.example.dz2_12.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        Number actual = calculatorService.plus(5, 6);
        assertThat(actual).isEqualTo(11.0);

        actual = calculatorService.plus(-6, 4);
        assertThat(actual).isEqualTo(-2.0);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorService.minus(6, 5);
        assertThat(actual).isEqualTo(1.0);

        actual = calculatorService.minus(-6, 4);
        assertThat(actual).isEqualTo(-10.0);
    }

    @Test
    public void multiplyTest() {
        Number actual = calculatorService.multiply(6, 5);
        assertThat(actual).isEqualTo(30.0);

        actual = calculatorService.multiply(-6, 4);
        assertThat(actual).isEqualTo(-24.0);
    }

    @Test
    public void divideTest() {
        Number actual = calculatorService.divide(6, 3);
        assertThat(actual).isEqualTo(2.0);

        actual = calculatorService.divide(-6, 3);
        assertThat(actual).isEqualTo(-2.0);
    }

    @Test
    public void divideNegativeTest() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(()-> calculatorService.divide(6, 0))
                .withMessage("На нуль делить нельзя!!!");

        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(()-> calculatorService.divide(-6, 0))
                .withMessage("На нуль делить нельзя!!!");
    }
}
