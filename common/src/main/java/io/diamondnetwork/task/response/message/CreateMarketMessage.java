package io.diamondnetwork.task.response.message;

public class CreateMarketMessage {

    /**
     * stock : dgss
     * money : usdt
     * creator : dkd1fdfu9g9nnwtgxdgfmgmxa9z9999usclfm85e40
     * price_precision : 2
     * order_precision : 2
     */

    private String stock;
    private String money;
    private String creator;
    private int price_precision;
    private int order_precision;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getPrice_precision() {
        return price_precision;
    }

    public void setPrice_precision(int price_precision) {
        this.price_precision = price_precision;
    }

    public int getOrder_precision() {
        return order_precision;
    }

    public void setOrder_precision(int order_precision) {
        this.order_precision = order_precision;
    }
}
