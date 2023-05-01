package test;

import main.models.Coin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinTest {

    @Test
    void getAddress() {
        Coin c = new Coin("tests", 1);
        assertEquals(c.getAddress(), "tests");
    }

    @Test
    void getAmount() {
        Coin c = new Coin("tests", 1);
        assertEquals(c.getAmount(), 1);
    }

}