package com.dvh.diffblue1;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SomeMockingTest {


    @BeforeAll
    static void beforeAllMethod() {

    }

    @BeforeEach
    void beforeEachMethod(){

    }

    @AfterEach
    void afterEachMethod(){

    }

    @AfterAll
    static void afterAllMethod(){

    }


    @Test
    void addSomeNumbers() {
        Double v1 = 5.2;
        Double v2 = 11.23;

        Double result = v1 + v2;

        assertThat( result ).isCloseTo(   16.4d, Percentage.withPercentage( 1.0 ) );
    }

    @Test
    void addSomeNumbers2() {


        Double v1 = 5.2;
        Double v2 = 11.23;

        Double result = v1 + v2;

        assertThat( result ).isCloseTo(   16.40d, Percentage.withPercentage( 1.0 ) );
    }



}
