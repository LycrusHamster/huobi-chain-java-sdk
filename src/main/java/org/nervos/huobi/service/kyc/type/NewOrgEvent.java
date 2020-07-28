package org.nervos.huobi.service.kyc.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrgEvent {
    private String name;
    private List<String> supported_tags;
}
