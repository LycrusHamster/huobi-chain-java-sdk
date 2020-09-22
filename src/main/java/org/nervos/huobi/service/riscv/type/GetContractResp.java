package org.nervos.huobi.service.riscv.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetContractResp {

    private String code_hash;
    private InterpreterType intp_type;
    private String code;
    private List<String> storage_values;
    private Address authorizer;
}
