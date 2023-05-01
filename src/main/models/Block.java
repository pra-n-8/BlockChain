package main.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Block extends Transaction {
    private Instant time;
    private List<Transaction> transactionList = new ArrayList<>();

    public Block(String add) {
        super(add);
        time = Instant.now();
        this.transactionList.add(super.getTransactions());
    }
    public Block(List<Coin> inputs, String address, Long amount){
        super(inputs,address,amount);
        time = Instant.now();
        this.transactionList.add(super.getTransactions());
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }
}
