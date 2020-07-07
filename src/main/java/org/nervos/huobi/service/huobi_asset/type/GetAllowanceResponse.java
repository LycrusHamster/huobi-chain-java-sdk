package org.nervos.huobi.service.huobi_asset.type;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllowanceResponse {
    private String asset_id;
    private String grantor;
    private String grantee;
    private BigInteger value;
}
