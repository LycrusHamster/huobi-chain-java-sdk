package org.nervos.huobi.service.kyc.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterNewOrg {
    private String name;
    private String description;
    private Address admin;
    private List<String> supported_tags;
}
