package com.dvh.diffblue1;

import org.assertj.core.data.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class SomeMockingTest {


    @Test
    void addSomeNumbers() {
        Double v1 = 5.2;
        Double v2 = 11.23;

        Double result = v1 + v2;

        assertThat( result ).isCloseTo(   15.0d, Percentage.withPercentage( 1.0 ) );
    }

    @Test
    void addSomeNumbers2() {


        Double v1 = 5.2;
        Double v2 = 11.23;

        Double result = v1 + v2;

        assertThat( result ).isCloseTo(   15.0d, Percentage.withPercentage( 1.0 ) );
    }



}
