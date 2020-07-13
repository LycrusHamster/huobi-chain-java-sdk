package org.nervos.huobi.service.huobi_asset.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAssetPayload {
    private String name;
    private String symbol;
    private U64 supply;
    private U64 precision;
    private boolean relayable;
}
