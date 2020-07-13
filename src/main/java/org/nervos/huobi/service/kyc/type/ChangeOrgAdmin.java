package org.nervos.huobi.service.kyc.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeOrgAdmin {
    private String name;
    private Address new_admin;
}
