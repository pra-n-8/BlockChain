package test;

import main.models.Coin;
import main.models.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void getInput() {
        Coin c = new Coin("test", 1);
        Coin c2 = new Coin("t2", 100);
        Transaction t = new Transaction(List.of(c, c2), "First transac", 500L);
        assertEquals(t.getInputs().size(), 2);
    }

    @Test
    void getOutput() {
        Coin c = new Coin("test", 1);
        Coin c2 = new Coin("t2", 100);
        Transaction t = new Transaction(List.of(c, c2), "First transac", 500L);
        assertEquals(t.getOutput().size(), 1);
    }

}