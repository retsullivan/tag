package org.improving.tag.Items;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

public abstract class Money implements Item{

    private String coinType;
    private int numCoins = 0;
    private Map moneyPouch = new HashMap<String, Integer>();

    Money (String coinType, int numCoins, Map moneyPouch){
        this.coinType = coinType;
        this.numCoins = numCoins;
        this.moneyPouch = moneyPouch;
    }


    public Map getMyMoney() {
        return moneyPouch;
    }

    public void addCoins(String coinType, int numCoins ){
        if (moneyPouch.containsKey(coinType)){
            moneyPouch.put(coinType, +numCoins);
        }
        else{
            moneyPouch.put(coinType, numCoins);
        }
    }

}
