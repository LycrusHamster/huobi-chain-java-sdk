package org.nervos.huobi.service.governance.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.ValidatorExtend;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateValidatorsPayload {
    private List<ValidatorExtend> verifier_list;
}
