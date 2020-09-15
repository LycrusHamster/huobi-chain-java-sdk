package org.nervos.huobi.service.timestamp.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimestampInfo {
    private Address admin;
    private boolean oracle;
}
