package io.diamondnetwork.model.dashboard;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("区块")
public class BlockStats {
    private int blockNumber;
    private int txNumber;
    private int accountNumber;
    private int assetNumber;
}
