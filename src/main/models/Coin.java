package main.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The Coin class represents a coin object in a cryptocurrency system.
 * Each coin has an address and an amount, and can have one or more input coins.
 */
public class Coin {
    private String address;
    private long amount;
    private List<Coin> inputs = new ArrayList<>();

    /**
     * Constructs a Coin object with the given address and amount.
     * Used to generate a coin from coinbase transaction
     *
     * @param address The address of the coin.
     * @param amount  The amount of the coin.
     */
    public Coin(String address, long amount) {
        this.address = address;
        this.amount = amount;
    }

    /**
     * Constructs a Coin object with the given address, amount, and list of input coins.
     * Used to generate coins from input coins
     *
     * @param address The address of the coin.
     * @param amount  The amount of the coin.
     * @param inputs  The list of input coins.
     */
    public Coin(String address, long amount, List<Coin> inputs) {
        this.address = address;
        this.amount = amount;
        this.inputs.addAll(inputs);
    }

    /**
     * Returns coin object.
     *
     * @return This coin object.
     */
    public Coin getCoin() {
        return this;
    }

    /**
     * Returns the address of the coin.
     *
     * @return The address of the coin.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the amount of the coin.
     *
     * @return The amount of the coin.
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Returns the list of input coins of this coin object.
     *
     * @return The list of input coins of this coin object.
     */
    public List<Coin> getInputs() {
        return inputs;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "address='" + address + '\'' +
                ", amount=" + amount +
                '}';
    }
}
