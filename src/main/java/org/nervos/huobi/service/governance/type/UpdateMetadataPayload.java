package org.nervos.huobi.service.governance.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.service.metadata.type.Metadata;

import java.util.Vector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMetadataPayload {
    private Vector<Metadata.ValidatorExtend> verifier_list;
    private String interval;
    private String propose_ratio;
    private String prevote_ratio;
    private String precommit_ratio;
    private String brake_ratio;
    private String timeout_gap;
    private String cycles_limit;
    private String cycles_price;
    private String tx_num_limit;
    private String max_tx_size;
}
