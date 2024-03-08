package com.ykhatab;

import org.junit.jupiter.api.*;

public class MainAppTest {

    @Test
    void givenMultiplesGameSequences_whenMainAppIsCalled_thenThrowsAnException(){
        //given
        var args = new String[]{"AAAABB","AAABBBBBBA"};

        //when
        var throwable = Assertions.assertThrows(
                //then
                IllegalArgumentException.class, ()->MainApp.main(args));
        Assertions.assertEquals("Invalid number of input arguments. Exactly one game sequence is expected as argument !", throwable.getMessage());
    }

    @Test
    void givenInvalidGameSequence_whenMainAppIsCalled_thenThrowsAnException(){
        //given
        var args = new String[]{"ABCDEFG"};

        //when
        var throwable = Assertions.assertThrows(
                //then
                IllegalArgumentException.class, ()->MainApp.main(args));
        Assertions.assertEquals("Invalid character in game sequence: C. Player names must be 'A' or 'B' !", throwable.getMessage());
    }

}
