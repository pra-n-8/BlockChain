package main.models;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private List<Block> blocks = null;

    public BlockChain(List<Block> blocks) {
        this.blocks = new ArrayList<>();
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(Block blocks) {
        this.blocks.add(blocks);
    }
}
