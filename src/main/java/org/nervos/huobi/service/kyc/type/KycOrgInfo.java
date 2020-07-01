package org.nervos.huobi.service.kyc.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KycOrgInfo {
    private  String name;
    private     String description;
    private String admin;
    private List<String> supported_tags;
    private boolean approved;
}
