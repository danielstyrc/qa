package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    // Zadanie 1
    @ParameterizedTest(name = "Test od wordpress powers with value {0}")
    @ValueSource(strings = {"1", "1000", "10000000"})
    public void zad1(String text){

        String resultString = "Wordpress powers " + text + "% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertTrue(resultString.startsWith("Wordpress powers "));
        assertTrue(resultString.endsWith("% of the internet"));
        assertThat(resultString).matches("(Wordpress powers )\\d+(% of the internet)"); //d+ oznacza ze wartosci numersyczne i bedzie wiecej niz 1

        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet", "");
        int resultNumber = Integer.parseInt(result);
        assertTrue(resultNumber > 0);

    }

    @ParameterizedTest(name = "Test od wordpress powers with value {0}")
    @ValueSource(strings = {"f1", "f", "1f", "11fss2"})
    public void zad1False(String text){

        String resultString = "Wordpress powers " + text + "% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertFalse(resultString.matches("\"(Wordpress powers )\\d+(% of the internet)\""));

    }


}
