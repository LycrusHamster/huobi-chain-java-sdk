package org.nervos.huobi.service.transfer_quota.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private U64 last_op_time;
    private U64 daily_used_amount;
    private U64 monthly_used_amount;
    private U64 yearly_used_amount;
}
