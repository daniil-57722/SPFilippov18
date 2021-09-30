package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Read_and_multTest_of_multiply {

    @org.junit.jupiter.api.Test
    void multiply() {
        String[] nums2 = { "10", "2" };
        Read_and_mult read_and_mult = new Read_and_mult();

        int res = (int) read_and_mult.multiply(nums2);

        Assertions.assertEquals(20, res);

    }
    @Test
    void minusmultiply(){
        String[] nums3 = {"-4", "2"};
        Read_and_mult read_and_mult = new Read_and_mult();

        int res = (int) read_and_mult.multiply(nums3);

        Assertions.assertEquals(-8, res);
    }
}