package org.nervos.huobi.service.governance.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.graphql_schema_scalar.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MinerChargeConfig {
  private Address address;
  private Address miner_charge_address;
}
