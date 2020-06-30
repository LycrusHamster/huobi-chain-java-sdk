package org.nervos.huobi.service.governance.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRatioPayload {
    private String propose_ratio;
    private String prevote_ratio;
    private String precommit_ratio;
    private String brake_ratio;
}
