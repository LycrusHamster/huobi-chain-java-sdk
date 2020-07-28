package org.nervos.huobi.service.huobi_asset.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuerWithBalance {
    private Address addr;
    private U64 balance;
}
