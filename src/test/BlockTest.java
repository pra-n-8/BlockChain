package test;

import main.models.Block;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockTest {

    @Test
    void getTime() {
        Block b = new Block("Test");
        assertEquals(b.getTime(), Instant.now());
    }

    @Test
    void getTransactionList() {
        Block b = new Block("Test");
        assertEquals(b.getTransactionList().size(), 1);
    }

}