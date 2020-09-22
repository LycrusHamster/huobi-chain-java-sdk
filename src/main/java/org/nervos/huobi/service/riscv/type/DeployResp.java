package org.nervos.huobi.service.riscv.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeployResp {
    private Address address;
    private String init_ret;
}
