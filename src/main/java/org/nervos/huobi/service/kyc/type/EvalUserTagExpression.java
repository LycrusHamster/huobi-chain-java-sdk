package org.nervos.huobi.service.kyc.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvalUserTagExpression {
    private String user;
    private String expression;
}
