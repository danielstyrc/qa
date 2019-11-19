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
