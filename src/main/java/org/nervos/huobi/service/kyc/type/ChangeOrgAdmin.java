package org.nervos.huobi.service.kyc.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeOrgAdmin {
  private String name;
  private String new_admin;
}
