package main.models;

import java.util.ArrayList;
import java.util.List;

public class Coin {
    private String address;
    private long amount;
    private List<Coin> inputs = new ArrayList<>();

    public Coin(String address, long amount) {
        this.address = address;
        this.amount = amount;
    }

    public Coin(String address, long amount,List<Coin> inputs) {
        this.address = address;
        this.amount = amount;
        this.inputs.addAll(inputs);
    }

    public Coin getCoin(){
        return this;
    };
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public List<Coin> getInputs() {
        return inputs;
    }

    public void setInputs(List<Coin> inputs) {
        this.inputs = inputs;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "address='" + address + '\'' +
                ", amount=" + amount +
                '}';
    }
}
