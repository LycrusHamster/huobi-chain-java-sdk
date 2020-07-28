package org.nervos.huobi.service.governance.type;

import java.util.Vector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.U64;
import org.nervos.muta.client.type.primitive.ValidatorExtend;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMetadataEvent {
    private Vector<ValidatorExtend> verifier_list;
    private U64 interval;
    private U64 propose_ratio;
    private U64 prevote_ratio;
    private U64 precommit_ratio;
    private U64 brake_ratio;
    private U64 timeout_gap;
    private U64 cycles_limit;
    private U64 cycles_price;
    private U64 tx_num_limit;
    private U64 max_tx_size;
}
