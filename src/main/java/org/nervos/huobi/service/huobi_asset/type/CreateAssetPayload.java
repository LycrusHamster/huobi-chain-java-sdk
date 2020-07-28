package org.nervos.huobi.service.huobi_asset.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAssetPayload {
    private String name;
    private String symbol;
    private Address admin;
    private U64 supply;
    private List<IssuerWithBalance> init_mints;
    private U64 precision;
    private boolean relayable;
}
