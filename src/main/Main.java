package main;

import main.models.Block;
import main.models.BlockChain;
import main.models.Coin;
import main.services.BlockChainService;
import main.services.CoinService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Coin> allCoin = new ArrayList<>();
        Block block1 = new Block("First");
        allCoin.addAll(block1.getOutput());

        Thread.sleep(2000);
        Block block = new Block("First but different");
        allCoin.addAll(block.getOutput());

        Thread.sleep(2000);
        Block block2 = new Block(block1.getOutput(), "192.168.1.1", 100L);
//        System.out.println(block2.getInput());
        allCoin.addAll(block2.getOutput());
        Thread.sleep(2000);
        Block block3 = new Block(allCoin,"168.110.112.2",30L);
//        System.out.println(block3.getInput());
        allCoin.addAll(block3.getOutput());

        BlockChain chain = new BlockChain(List.of(block1,block2,block3));
        BlockChainService bcs = new BlockChainService();

        Block block4 = new Block(allCoin,"192.168.1.1",10L);
        allCoin.addAll(block4.getOutput());

        chain.setBlocks(block4);

        Block block5 = new Block(allCoin,"168.110.112.2",1000L);
        allCoin.addAll(block5.getOutput());

        chain.setBlocks(block5);

        System.out.println(bcs.find_maximum_inbound_volume_address(chain,"T15:00:00","T20:00:00"));
//        chain.getBlocks().forEach(x-> System.out.println(x.getTime()));
        CoinService cs = new CoinService();
        Coin coin = allCoin.get(3);
        System.out.println(coin);
        System.out.println(cs.find_coinbase_ancestors(coin));

    }
}
