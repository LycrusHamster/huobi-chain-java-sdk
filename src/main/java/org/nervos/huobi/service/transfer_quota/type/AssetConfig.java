package org.nervos.huobi.service.transfer_quota.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetConfig {
    private Address admin;
    private boolean activated;
    private List<Rule> single_bill_quota;
    private List<Rule> daily_quota_rule;
    private List<Rule> monthly_quota_rule;
    private List<Rule> yearly_quota_rule;
}
