package main.models;

import java.util.ArrayList;
import java.util.List;

public class Transaction extends Coin {
    private boolean isCoinbase;
    private List<Coin> input = new ArrayList<>();
    private List<Coin> output = new ArrayList<>();

    public Transaction(String add) {
        super(add, (long) Math.random());
        this.isCoinbase = true;
        this.input = new ArrayList<>();
        output.addAll(this.setCoin(super.getCoin()));
    }

    public Transaction(List<Coin> input,String address, Long amount) {
        super(address,amount,input);
        this.isCoinbase = false;
        this.input.addAll(input);
        this.setOutput(super.getCoin(),input);
    }

    public List<Coin> getInput() {
        return input;
    }

    public List<Coin> getOutput() {
        return output;
    }

    private void setOutput(Coin coin, List<Coin> input) {
        output.add(coin);
    }

    private List<Coin> setCoin(Coin coin) {
        return List.of(coin);
    }

    public Transaction getTransactions(){
        return this;
    }

}
