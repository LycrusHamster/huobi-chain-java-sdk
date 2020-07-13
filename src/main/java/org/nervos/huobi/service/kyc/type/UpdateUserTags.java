package org.nervos.huobi.service.kyc.type;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserTags {
    private String org_name;
    private Address user;
    private Map<String, List<String>> tags;
}
