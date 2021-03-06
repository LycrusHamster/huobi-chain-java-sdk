package org.nervos.huobi.service.huobi_asset.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.Hash;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeAdminPayload {
    private Hash asset_id;
    private Address addr;
}
