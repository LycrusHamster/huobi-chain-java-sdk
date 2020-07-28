package org.nervos.huobi.service.governance.type;

import java.util.Vector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.ValidatorExtend;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateValidatorsEvent {
    private Vector<ValidatorExtend> verifier_list;
}
