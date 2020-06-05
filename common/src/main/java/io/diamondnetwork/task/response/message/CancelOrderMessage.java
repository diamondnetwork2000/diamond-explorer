package io.diamondnetwork.task.response.message;

public class CancelOrderMessage {

    /**
     * sender : dkd1w9nnckmmqmwmcfmyk9mnc47xgkk7he979qljs6
     * order_id : dkd1w9nnckmmqmwmcfmyk9mnc47xgkk7he979qljs6-257
     */

    private String sender;
    private String order_id;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
