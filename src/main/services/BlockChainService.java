package main.services;

import main.models.Block;
import main.models.BlockChain;

import java.util.*;

class Time {
    int hours;
    int mins;
    Double sec;

    public Time(int hours, int mins, double sec) {
        this.hours = hours;
        this.mins = mins;
        this.sec = sec;
    }

}

public class BlockChainService {
    HashMap<String,Long> maxValAdd = new HashMap<>();
    public String find_maximum_inbound_volume_address(BlockChain chain, String interval_start, String interval_end) {
        Time startTime = getTime(interval_start);
        Time endTime = getTime(interval_end);

        for (Block block : chain.getBlocks()) {
            Time blockTime = getTime(block.getTime().toString());
            if(blockTime.hours>=startTime.hours && blockTime.hours<endTime.hours){
                addMaxValAdd(block);
            }
        }
        return sortMaxVal().toString();
    }

    private void addMaxValAdd (Block block){
        if(maxValAdd.containsKey(block.getAddress())){
            maxValAdd.replace(block.getAddress(), maxValAdd.get(block.getAddress())+block.getAmount());
        }
        else{

            maxValAdd.put(block.getAddress(), block.getAmount());
        }

    }

    private Map.Entry sortMaxVal(){
        ArrayList arraylist = new ArrayList<>();
        for(Map.Entry entry : maxValAdd.entrySet()){
            arraylist.add(entry);
        }
        Collections.sort(arraylist, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1,Map.Entry o2) {
                return Long.compare((Long) o1.getValue(),(Long)o2.getValue());
            }
        });
        Collections.reverse(arraylist);
        return (Map.Entry) arraylist.remove(0);
    }

    private Time getTime(String time) {
        String[] split = time.split("T");
        String[] splitTime = split[1].split(":");
        return new Time(Integer.parseInt(splitTime[0]), Integer.parseInt(splitTime[1]), Double.parseDouble(splitTime[2].substring(0, splitTime[2].length() - 1)));
    }
}
