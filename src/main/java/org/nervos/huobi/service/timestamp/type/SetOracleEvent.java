package org.nervos.huobi.service.timestamp.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetOracleEvent {
    private boolean oracle;
}
