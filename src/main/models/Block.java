package main.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Block {
    private Instant time;
    private List<Transaction> transactionList;

    public Block() {
        time = Instant.now();
        this.transactionList = new ArrayList<>();
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
