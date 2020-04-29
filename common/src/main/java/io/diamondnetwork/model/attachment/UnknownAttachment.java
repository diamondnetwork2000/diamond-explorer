package io.diamondnetwork.model.attachment;

import io.diamondnetwork.model.Attachment;
import lombok.Data;

@Data
public class UnknownAttachment extends Attachment {
    private String description;
    public UnknownAttachment() {
        super(null, (byte)0);
        this.description = "Unknown Attachment";
    }
}
