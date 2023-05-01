package test;

import main.models.Block;
import main.models.BlockChain;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockChainTest {


    @Test
    void getBlocks() {
        Block block = new Block("Test");
        BlockChain bc = new BlockChain(List.of(block));
        assertEquals(bc.getBlocks().size(), 1);
    }

    @Test
    void setBlocks() {
        Block block = new Block("Test");
        BlockChain bc = new BlockChain(List.of(block));
        Block newBlock = new Block("Test2");
        bc.setBlocks(newBlock);
        assertEquals(bc.getBlocks().size(), 2);
    }
}