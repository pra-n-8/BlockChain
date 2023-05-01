package main.models;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private boolean isCoinbase;
    private List<Coin> input;
    private List<Coin> output = new ArrayList<>();

    public Transaction() {
        this.isCoinbase = true;
        this.input = new ArrayList<>();
        this.output = setCoin();
    }

    public Transaction(List<Coin> input) {
        this.isCoinbase = false;
        this.input = input;
        setOutput();
    }

    public List<Coin> getInput() {
        return input;
    }

    public void setInput(List<Coin> input) {
        this.input = input;
    }

    public List<Coin> getOutput() {
        return output;
    }

    private void setOutput() {
        Coin newCoin = new Coin("Coin 2", 1);
        getInput().forEach(x -> newCoin.setAmount(newCoin.getAmount() + x.getAmount()));
        output.add(newCoin);
    }

    private List<Coin> setCoin() {
        Coin coin = new Coin("First Coin", 1);
        return List.of(coin);
    }
}
