package org.nervos.huobi.service.admission_control.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.graphql_schema_scalar.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewAdmin {
  private Address new_admin;
}
