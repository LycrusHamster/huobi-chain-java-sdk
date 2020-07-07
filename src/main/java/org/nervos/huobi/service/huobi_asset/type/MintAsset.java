package org.nervos.huobi.service.huobi_asset.type;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MintAsset {
    private String asset_id;
    private String to;
    private BigInteger amount;
    private String proof;
    private String memo;
}
