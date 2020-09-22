package org.nervos.huobi.service.riscv.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetContractPayload {
    private Address address;
    private boolean get_code;
    private List<String> storage_keys;
}
