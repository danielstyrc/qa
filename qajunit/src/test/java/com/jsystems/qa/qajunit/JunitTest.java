package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Junit tests")
@Tag("unit") //otagowanie testu
public class JunitTest extends ConfigJunit {

// All monza wyciagnac poza klase jako extends bo sie powtarza, Each pozostaje tutaj
//    @BeforeAll
//    public static void setupAll() {
//        System.out.println("======================BeforeAll======================");
//    }

    @BeforeEach
    public void setupEach(TestInfo testInfo) {
        System.out.println("======================BeforeEach======================");
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestMethod());
    }

//    @AfterAll
//    public static void tearDownAll() {
//        System.out.println("======================AfterAll======================");
//    }

    @AfterEach
    public void tearDownEach() {
        System.out.println("======================AfterEach======================");
    }

    final String stringTestowy = "stringTestowy";

    @DisplayName("First junit tests") //kolejność adnotacji ma znaczenie
    @Disabled("bug: import , 1230") // np jest bug, dlatego nie uruchomi testu
 //   @RepeatedTest(5) // uruchom test 5 razy
    @Tag("first")
    @Test
    public void firstTest() {
        assertTrue(stringTestowy.contains("tr"));
        assertTrue(5 == 2 + 3, "message for test result");
//        assertFalse(stringTestowy.matches("[a-z]"));
        assertFalse(stringTestowy.contains("z"));
//        assertThat(stringTestowy).contains("s"); // lepsze rozwiązanie, string tekstowy zawiera literę s
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        assertThat(stringTestowy).endsWith("wy");

    }

    @Tag("second")
    @Test
    public void secondTest() {
        System.out.println(0.2 * 0.2);
        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        System.out.println(result);
        assertTrue(result == 0.04);
//        assertTrue(0.2 * 0.2 == 0.04); // to nie jest poprawny wynik, bo to jest maszyna, wazne dla walut i pieniedzy, tylko na String'ach

    }

    @Test
    public void stringTest(){

        String simpleString = "simpleString";
        String simple = "simpleString";
        String simpleString_2 = new String("simpleString");
        String simpleString_3 = new String("simpleString");

        assertTrue(simpleString == "simpleString");
        assertTrue(simpleString == simple);
        assertFalse(simpleString == simpleString_2);
        assertFalse(simpleString_2 == simpleString_3);
        assertTrue(simpleString.equals(simple));
        assertTrue(simpleString_2.equals(simpleString_3));
        int a = 1;
        Integer a_1 = 1;

    }

    // Zadanie 1
    @Test
    public void zad1(){

        String resultString = "Wordpress powers 34% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertTrue(resultString.startsWith("Wordpress powers "));
        assertTrue(resultString.endsWith("% of the internet"));
        assertThat(resultString).matches("(Wordpress powers )\\d+(% of the internet)"); //d+ oznacza ze wartosci numersyczne i bedzie wiecej niz 1

        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet", "");
        int resultNumber = Integer.parseInt(result);
        assertTrue(resultNumber > 0);

    }


    // zagniedzone suity (sjute)
    @Nested
    public class NestedTest {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5);

        @Test
        public void firstNestedTest() {
            assertTrue(list1.containsAll(list2)); // czy lista1 zawiera elementy z listy2
            assertThat(list1).hasSize(5);
            assertThat(list1).containsAnyOf(1,2,3);

        }

        @Test
        public void secondNestedTest() {

        }

    }

}

            /*
zakres komentarza od-do
"""
do jsona np
albo zapytan baz danych
select * from
"""
*/
