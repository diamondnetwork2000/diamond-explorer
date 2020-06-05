package io.diamondnetwork.task.response.message;

import io.diamondnetwork.util.JSONUtil;
import lombok.Data;

@Data
public class TxMessage {
    private String type;
    //Convert to specific message according to type
    private Object value;

    public Object toValue() {
        Class type = toType();
        if (type != null) {
            return JSONUtil.parseToObject(JSONUtil.toJSONString(value), type);
        }

        return null;
    }

    private Class  toType(){
        Class c = null;
        if (type.equals("market/MsgCreateTradingPair")) {
            c = CreateMarketMessage.class;
        } else if (type.equals("market/MsgModifyPricePrecision")) {
            c = ModifyMarketPrecision.class;
        } else if (type.equals("market/MsgCreateOrder")) {
            c = CreateOrderMessage.class;
        } else if (type.equals("market/MsgCancelOrder")) {
            c = CancelOrderMessage.class;
        }

        return c;
    }
}
