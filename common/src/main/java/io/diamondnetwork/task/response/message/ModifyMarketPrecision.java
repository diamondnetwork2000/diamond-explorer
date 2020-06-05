package io.diamondnetwork.task.response.message;

public class ModifyMarketPrecision {

    /**
     * sender : dkd1fdfu9g9nnwtgxdgfmgmxa9z9999usclfm85e40
     * trading_pair : dgss/usdt
     * price_precision : 4
     */

    private String sender;
    private String trading_pair;
    private int price_precision;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTrading_pair() {
        return trading_pair;
    }

    public void setTrading_pair(String trading_pair) {
        this.trading_pair = trading_pair;
    }

    public int getPrice_precision() {
        return price_precision;
    }

    public void setPrice_precision(int price_precision) {
        this.price_precision = price_precision;
    }
}
