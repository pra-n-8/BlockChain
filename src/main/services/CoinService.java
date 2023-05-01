package main.services;

import main.models.Coin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * A service class that provides a method to find the coinbase ancestors of a given coin.
 */
public class CoinService {
    /**
     * Returns a list of coinbase ancestors for the given coin.
     *
     * @param coin The coin for which to find the coinbase ancestors.
     * @return A list of coinbase ancestors for the given coin.
     */
    public List<Coin> find_coinbase_ancestors(Coin coin) {
        Set<Coin> ancestors = new HashSet<>();
        if (coin.getInputs().size() == 0) {
            ancestors.add(coin);
        } else {
            for (Coin coins : coin.getInputs()) {
                ancestors.addAll(find_coinbase_ancestors(coins));
            }
        }
        return ancestors.stream().toList();
    }
}
