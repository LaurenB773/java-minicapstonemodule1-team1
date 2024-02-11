package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class UIMethodTests {

    @Test
    public void menu_doesnt_accept_empty_strings() {
        String animalName = "";
        UI sut = new UI();

        String actual = sut.menu();

        Assert.assertEquals("unknown", actual);
    }


}
