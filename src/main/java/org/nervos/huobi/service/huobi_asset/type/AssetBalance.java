package org.nervos.huobi.service.huobi_asset.type;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetBalance {
    private U64 value;
    private Map<Address, U64> allowance;
}
