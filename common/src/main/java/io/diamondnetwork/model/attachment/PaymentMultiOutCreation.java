package io.diamondnetwork.model.attachment;

import burst.kit.crypto.BurstCrypto;
import burst.kit.entity.BurstID;
import io.diamondnetwork.model.Attachment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.ByteBuffer;
import java.util.ArrayList;

@Data
public class PaymentMultiOutCreation extends Attachment {
    private final ArrayList<Multiout> recipients = new ArrayList<>();

    @Data
    @AllArgsConstructor
    public static class Multiout {
        private long recipientId;
        private long amountNQT;

        public String getRecipientRS () {
            if (recipientId == 0) {
                return "N/A";
            }

            String rs = BurstCrypto.getInstance().rsEncode(BurstID.fromLong(recipientId));
            return "1x" + rs.replaceAll("-","");
        }
    }

    public PaymentMultiOutCreation(ByteBuffer buffer, byte transactionVersion) {
        super(buffer, transactionVersion);
        int numberOfRecipients = Byte.toUnsignedInt(buffer.get());
        //HashMap<Long,Boolean> recipientOf = new HashMap<>(numberOfRecipients);

        //这段代码是从Burst里拿来的， 只是去掉了校验的代码，因为这是浏览器，查到的交易都是已经验证通过的了， 不需要再次验证
        for (int i = 0; i < numberOfRecipients; ++i) {
            long recipientId = buffer.getLong();
            long amountNQT = buffer.getLong();

          /*  if (recipientOf.containsKey(recipientId))
                throw new BurstException.NotValidException("Duplicate recipient on multi out transaction");

            if (amountNQT <= 0)
                throw new BurstException.NotValidException("Insufficient amountNQT on multi out transaction");*/

           // recipientOf.put(recipientId, true);
            this.recipients.add(new Multiout(recipientId, amountNQT));
        }
        /*if (recipients.size() > Constants.MAX_MULTI_OUT_RECIPIENTS || recipients.size() <= 1) {
            throw new BurstException.NotValidException(
                    "Invalid number of recipients listed on multi out transaction");
        }*/
    }
}
