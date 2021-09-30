package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Read_and_multTest_of_reading {

    @Test
    void read() {
        Read_and_mult read_and_mult = new Read_and_mult();
        String text = (String) read_and_mult.read();
        boolean result = text.matches("\\d* ?\\* ?\\d*");

        Assertions.assertEquals(true, result);


    }
}