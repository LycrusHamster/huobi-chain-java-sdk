package org.nervos.huobi.service.governance.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetGovernInfoEvent {
    private GovernanceInfo info;
}
