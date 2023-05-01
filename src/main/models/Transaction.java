package main.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The Transaction class represents a single transaction in a blockchain network.
 * It extends the Coin class and adds the functionality to store input and output coins for a transaction.
 * A transaction can be either a coinbase transaction or a regular transaction.
 * For a coinbase transaction, the constructor generates a random amount and sets the input to an empty list.
 * For a regular transaction, the constructor takes a list of input coins, output address and amount, and sets the input and output lists accordingly.
 */
public class Transaction extends Coin {
    /**
     * A boolean flag indicating whether the transaction is a coinbase transaction.
     */
    private boolean isCoinbase;
    /**
     * A list of input coins for the transaction.
     */
    private List<Coin> input = new ArrayList<>();
    /**
     * A list of output coins for the transaction.
     */
    private List<Coin> output = new ArrayList<>();

    /**
     * Creates a coinbase transaction with the specified address.
     *
     * @param add The address for the transaction.
     */
    public Transaction(String add) {
        super(add, (long) Math.random());
        this.isCoinbase = true;
        this.input = new ArrayList<>();
        output.addAll(this.setCoin(super.getCoin()));
    }

    /**
     * Creates a regular transaction with the specified input coins, output address and amount.
     *
     * @param input   The list of input coins for the transaction.
     * @param address The output address for the transaction.
     * @param amount  The output amount for the transaction.
     */
    public Transaction(List<Coin> input, String address, Long amount) {
        super(address, amount, input);
        this.isCoinbase = false;
        this.input.addAll(input);
        this.setOutput(super.getCoin(), input);
    }


    /**
     * Returns the list of output coins for the transaction.
     *
     * @return The list of output coins for the transaction.
     */
    public List<Coin> getOutput() {
        return output;
    }

    /**
     * Sets the output coin for the transaction.
     *
     * @param coin  The output coin for the transaction.
     * @param input The list of input coins for the transaction.
     */
    private void setOutput(Coin coin, List<Coin> input) {
        output.add(coin);
    }

    /**
     * Returns the current transaction.
     *
     * @return The current transaction.
     */
    private List<Coin> setCoin(Coin coin) {
        return List.of(coin);
    }

    /**
     * Returns a list containing the specified coin.
     *
     * @param coin The coin to add to the list.
     * @return A list containing the specified coin.
     */
    public Transaction getTransactions() {
        return this;
    }

}
