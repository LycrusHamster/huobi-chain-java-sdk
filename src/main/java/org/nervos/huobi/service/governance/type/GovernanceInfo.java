package org.nervos.huobi.service.governance.type;

import java.util.Vector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.U64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GovernanceInfo {
    private Address admin;
    private U64 tx_failure_fee;
    private U64 tx_floor_fee;
    private U64 profit_deduct_rate_per_million;
    private Vector<DiscountLevel> tx_fee_discount;
    private U64 miner_benefit;
}
