package org.nervos.huobi.service.huobi_asset.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.Hash;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferFromEvent {
    private Hash asset_id;
    private Address caller;
    private Address sender;
    private Address recipient;
    private U64 value;
    private String memo;
}
