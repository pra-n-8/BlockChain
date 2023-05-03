package main.services;

import main.models.Block;
import main.models.BlockChain;

import java.time.Instant;
import java.util.*;

/**
 * Represents a time in hours, minutes, and seconds.
 */
class Time {
    int hours;
    int mins;
    Double sec;

    /**
     * Constructs a new Time object with the specified hours, minutes, and seconds.
     *
     * @param hours the number of hours
     * @param mins  the number of minutes
     * @param sec   the number of seconds
     */
    public Time(int hours, int mins, double sec) {
        this.hours = hours;
        this.mins = mins;
        this.sec = sec;
    }

}

/**
 * This class provides functionality to find the address with the maximum
 * inbound volume within a specified time interval in a given blockchain.
 */

public class BlockChainService {
    HashMap<String, Long> maxValAdd = new HashMap<>();

    /**
     * Finds the address with the maximum inbound volume within the specified time
     * interval in the given blockchain.
     *
     * @param chain          the blockchain to search
     * @param interval_start the start of the time interval, in format
     *                       (THH:mm:ss.SSS)
     * @param interval_end   the end of the time interval, in format (THH:mm:ss.SSS)
     * @return the address with the maximum inbound volume, as a string
     */
    public String find_maximum_inbound_volume_address(BlockChain chain, Instant interval_start, Instant interval_end) {
        try {
            for (Block block : chain.getBlocks()) {
                if (block.getTime().isAfter(interval_start) && block.getTime().isBefore(interval_end)) {
                    addMaxValAdd(block);
                }
            }
        } catch (Exception e) {
            return null;
        }
        if(sortMaxVal() == null){
            return null;
        }
        else{
        return sortMaxVal().toString();
        }
    }

    /**
     * Adds the specified block's inbound volume to the maximum inbound volume for
     * its address.
     *
     * @param block the block to add
     */
    private void addMaxValAdd(Block block) {
        if (maxValAdd.containsKey(block.getAddress())) {
            maxValAdd.replace(block.getAddress(), maxValAdd.get(block.getAddress()) + block.getAmount());
        } else {
            maxValAdd.put(block.getAddress(), block.getAmount());
        }

    }

    /**
     * Sorts the maximum inbound volumes in descending order and returns the address
     * with the highest value.
     *
     * @return the address with the maximum inbound volume
     */
    private Map.Entry sortMaxVal() {
        try {
            ArrayList arraylist = new ArrayList<>();
            for (Map.Entry entry : maxValAdd.entrySet()) {
                arraylist.add(entry);
            }
            Collections.sort(arraylist, new Comparator<Map.Entry>() {
                @Override
                public int compare(Map.Entry o1, Map.Entry o2) {
                    return Long.compare((Long) o1.getValue(), (Long) o2.getValue());
                }
            });
            Collections.reverse(arraylist);
            if (arraylist.size() > 0) {
                return (Map.Entry) arraylist.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
