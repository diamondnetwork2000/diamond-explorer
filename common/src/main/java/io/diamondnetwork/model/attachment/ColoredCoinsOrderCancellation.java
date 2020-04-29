package io.diamondnetwork.model.attachment;

import io.diamondnetwork.model.Attachment;
import io.diamondnetwork.model.Order;
import lombok.Data;

import java.nio.ByteBuffer;
@Data
public class ColoredCoinsOrderCancellation extends Attachment {
    private final long orderId;
    private Order order;

    public ColoredCoinsOrderCancellation(ByteBuffer buffer, byte transactionVersion) {
        super(buffer, transactionVersion);
        this.orderId = buffer.getLong();
    }
}
