package main.services;

import main.models.Coin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinService {
    public List<Coin> find_coinbase_ancestors(Coin coin) {
       Set<Coin> ancestors = new HashSet<>();
        if (coin.getInputs().size()==0) {
            ancestors.add(coin);
        }
        else {
            for (Coin coins : coin.getInputs()) {
                ancestors.addAll(find_coinbase_ancestors(coins));
            }
        }
        return ancestors.stream().toList();
    }
}
