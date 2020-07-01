package org.nervos.huobi.service.kyc.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrgSupportTags {
    private String org_name;
    private List<String > supported_tags;
}
