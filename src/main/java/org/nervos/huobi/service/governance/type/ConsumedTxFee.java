package org.nervos.huobi.service.governance.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumedTxFee {
    public static final String name = "ConsumedTxFee";
    private Address caller;
    private Address miner;
    private U64 amount;
}
