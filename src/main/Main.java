package main;

import main.models.Block;
import main.models.BlockChain;
import main.models.Coin;
import main.models.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Block block = new Block();
        Transaction transaction = new Transaction();
        List<Coin> coins = transaction.getOutput();
        block.addTransaction(transaction);
        Transaction transaction1 = new Trasnsaction(coins);
        coins.addAll(transaction1.getOutput());
        block.addTransaction(transaction1);
        BlockChain blockChain = new BlockChain(List.of(block));
        blockChain.setBlocks(block);
        System.out.println(blockChain);
    }
}
