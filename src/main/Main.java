package main;

import main.models.Block;
import main.models.BlockChain;
import main.models.Coin;
import main.services.BlockChainService;
import main.services.CoinService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Method to run the project
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Instant time = Instant.now();
        // List to store all the coins generated
        List<Coin> allCoin = new ArrayList<>();
        //        Creating Coinbase Block
        Block block1 = new Block("First");
        allCoin.addAll(block1.getOutput());

        //        Sleeping to add time difference between transactions
        Thread.sleep(2000);

        //        Creating another Coinbase block
        Block block = new Block("First but different");
        allCoin.addAll(block.getOutput());

        //        Sleeping to add time difference between transactions
        Thread.sleep(2000);

        //        Creating a new transaction block using output coins from first 2 blocks
        Block block2 = new Block(block1.getOutput(), "192.168.1.1", 10L);
        //      Adding the output of the transaction to the coins list
        allCoin.addAll(block2.getOutput());

        //        Sleeping to add time difference between transactions
        Thread.sleep(2000);

        //        Creating a new transaction block using output coins from first 3 blocks
        Block block3 = new Block(allCoin, "168.110.112.2", 30L);
        allCoin.addAll(block3.getOutput());
        //        Adding all the blocks to the blockchain
        BlockChain chain = new BlockChain(List.of(block1, block2, block3));
        BlockChainService bcs = new BlockChainService();

        //        Creating a new transaction block using output coins
        Block block4 = new Block(allCoin, "192.168.1.1", 10L);
        allCoin.addAll(block4.getOutput());

        chain.setBlocks(block4);

        //        Creating a new transaction block using output coins
        Block block5 = new Block(allCoin, "168.110.112.2", 100L);
        allCoin.addAll(block5.getOutput());

        chain.setBlocks(block5);

        //        Printing the max inbound volume address
        System.out.println("Max inbound volume is at :");
        Thread.sleep(8000);
        Instant t2 = Instant.now();
        System.out.println(bcs.find_maximum_inbound_volume_address(chain, time, t2));

        //      Get the coinbase ancestors of a coin
        CoinService cs = new CoinService();
        Coin coin = allCoin.get(3);
        System.out.println(coin + " ancestor are");
        System.out.println(cs.find_coinbase_ancestors(coin));

    }
}
