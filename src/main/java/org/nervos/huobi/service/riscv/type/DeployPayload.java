package org.nervos.huobi.service.riscv.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeployPayload {
    private String code;
    private InterpreterType intp_type;
    private String init_args;
}
