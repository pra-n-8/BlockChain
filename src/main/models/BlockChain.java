package main.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The BlockChain class represents a blockchain, which is a distributed ledger of blocks that are linked together
 * This class manages a list of Block objects that represent individual blocks in the chain.
 */
public class BlockChain {
    /**
     * The list of blocks that make up the blockchain.
     */
    private List<Block> blocks = new ArrayList<>();

    /**
     * Constructs a new blockchain with the specified list of blocks.
     *
     * @param blocks The list of blocks to initialize the blockchain with.
     */
    public BlockChain(List<Block> blocks) {
        this.blocks.addAll(blocks);
    }

    /**
     * Gets the list of blocks in the blockchain.
     *
     * @return The list of blocks in the blockchain.
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * Adds a new block to the blockchain.
     *
     * @param block The block to add to the blockchain.
     */
    public void setBlocks(Block blocks) {
        this.blocks.add(blocks);
    }
}
