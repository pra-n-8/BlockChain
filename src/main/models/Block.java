package main.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A Block class that represents a block in a blockchain system.
 * This class extends the Transaction class and adds a timestamp and a list of transactions to the block.
 */
public class Block extends Transaction {
    /**
     * The time that this block was created as an Instant object.
     */
    private Instant time;
    /**
     * A list of transactions included in this block.
     */
    private List<Transaction> transactionList = new ArrayList<>();

    /**
     * Constructs a new Block object with the given address and sets the time to the current time.
     * Adds the transaction list of the parent Transaction object to this block's transaction list.
     * Used to create a coinbase transaction
     *
     * @param add the address associated with this block
     */
    public Block(String add) {
        super(add);
        time = Instant.now();
        this.transactionList.add(super.getTransactions());
    }

    /**
     * Constructs a new Block object with the given inputs, address, and amount, and sets the time to the current time.
     * Adds the transaction list of the parent Transaction object to this block's transaction list.
     * Denotes transactions of coins
     *
     * @param inputs  the list of coins used as inputs for this transaction
     * @param address the address associated with this block
     * @param amount  the amount of coins transferred in this transaction
     */
    public Block(List<Coin> inputs, String address, Long amount) {
        super(inputs, address, amount);
        time = Instant.now();
        this.transactionList.add(super.getTransactions());
    }

    /**
     * Gets the time that this block was created.
     *
     * @return the time that this block was created as an Instant object
     */
    public Instant getTime() {
        return time;
    }

    /**
     * Gets the list of transactions included in this block.
     *
     * @return the list of transactions included in this block
     */
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

}
