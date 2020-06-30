package org.nervos.huobi.service.governance.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Vector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GovernanceInfo {
    private String admin;
    private String tx_failure_fee;
    private String tx_floor_fee;
    private String profit_deduct_rate_per_million;
    private Vector<DiscountLevel> tx_fee_discount;
    private String miner_benefit;
}
