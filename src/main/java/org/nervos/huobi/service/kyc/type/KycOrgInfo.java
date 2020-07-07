package org.nervos.huobi.service.kyc.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KycOrgInfo {
    private String name;
    private String description;
    private String admin;
    private List<String> supported_tags;
    private boolean approved;
}
