package org.nervos.huobi.service.governance.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRatioEvent {
    private U64 propose_ratio;
    private U64 prevote_ratio;
    private U64 precommit_ratio;
    private U64 brake_ratio;
}
