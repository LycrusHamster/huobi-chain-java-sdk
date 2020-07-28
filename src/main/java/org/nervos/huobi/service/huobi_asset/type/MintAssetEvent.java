package org.nervos.huobi.service.huobi_asset.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.Hash;
import org.nervos.muta.client.type.primitive.Hex;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MintAssetEvent {
    private Hash asset_id;
    private Address to;
    private U64 amount;
    private Hex proof;
    private String memo;
}
