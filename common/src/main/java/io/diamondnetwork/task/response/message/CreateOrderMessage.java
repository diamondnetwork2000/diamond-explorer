package io.diamondnetwork.task.response.message;

public class CreateOrderMessage {


    /**
     * sender : dkd1w9nnckmmqmwmcfmyk9mnc47xgkk7he979qljs6
     * identify : 1
     * trading_pair : dgss/usdt
     * order_type : 2
     * price_precision : 8
     * price : 100000
     * quantity : 10000000000
     * side : 1
     * time_in_force : 3
     * exist_blocks : 20811
     */

    private String sender;
    private int identify;
    private String trading_pair;
    private int order_type;
    private int price_precision;
    private String price;
    private String quantity;
    private int side;
    private String time_in_force;
    private String exist_blocks;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public String getTrading_pair() {
        return trading_pair;
    }

    public void setTrading_pair(String trading_pair) {
        this.trading_pair = trading_pair;
    }

    public int getOrder_type() {
        return order_type;
    }

    public void setOrder_type(int order_type) {
        this.order_type = order_type;
    }

    public int getPrice_precision() {
        return price_precision;
    }

    public void setPrice_precision(int price_precision) {
        this.price_precision = price_precision;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public String getTime_in_force() {
        return time_in_force;
    }

    public void setTime_in_force(String time_in_force) {
        this.time_in_force = time_in_force;
    }

    public String getExist_blocks() {
        return exist_blocks;
    }

    public void setExist_blocks(String exist_blocks) {
        this.exist_blocks = exist_blocks;
    }
}
