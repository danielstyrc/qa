package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QaParameterizedTest extends ConfigJunit {

//    @Test
    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(ints = {5, 15, 25})
    public void firstParameterizedTest(int number) {

        assertTrue(number % 5 == 0);

 //       int[] ints = {5, 15, 25};
 //       for(int i =0; i <ints.length; i++) {
 //           assertTrue(ints[i] % 5 == 0);
//        }


    }


    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(strings = {"Hello", "Hello junit", "Hello students"})
    public void secondParameterizedTest(String text) {

        assertTrue(text.contains("Hello"));

    }

    //przydatne do testow API dla wartosci brzegowych
    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @CsvSource(value = {"Hello, 5", "Hello junit 5, 15", "'Hello 5!', 25"}, delimiter = ',') // zestaw parametrów
    public void nextParameterizedTest(String text, int number) {
        assertTrue(text.contains("Hello"));
        assertTrue(number % 5 == 0);

    }

    //
    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ',')
    public void csvFileParameterizedTest(String text, int number) {
        assertTrue(text.contains("Hello"));
        assertTrue(number % 5 == 0);

    }

    //Enum
    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @EnumSource(value = ParamEnum.class)
    public void enumParameterizedTest(ParamEnum enumtype) {

        assertTrue(enumtype.toString().contains("ENUM")); // do porownania stringow nigdy nie uzywamy == tylko equals

    }

    enum ParamEnum {
        ENUM_ONE,
        ENUM_TWO
    }


}
