package org.nervos.huobi.service.governance.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.service.metadata.type.Metadata;

import java.util.Vector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateValidatorsPayload {
    private Vector<Metadata.ValidatorExtend> verifier_list;
}
