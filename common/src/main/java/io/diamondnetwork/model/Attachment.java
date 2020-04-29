package io.diamondnetwork.model;

import lombok.Data;

import java.io.Serializable;
import java.nio.ByteBuffer;
@Data
public class Attachment implements Serializable {
    private final byte version;

    public Attachment(ByteBuffer buffer, byte transactionVersion) {
        version = (transactionVersion == 0) ? 0 : buffer.get();
    }
}
