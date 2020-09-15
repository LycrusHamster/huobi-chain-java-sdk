package org.nervos.huobi.service.transfer_quota.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Hash;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAssetConfigPayload {
    private Hash asset_id;
}
