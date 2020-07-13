package org.nervos.huobi.service.huobi_asset.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Hash;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAssetPayload {
    private Hash id;
}
