package org.nervos.huobi.service.riscv.type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetContractPayload {
  private String address;
  private boolean get_code;
  private List<String> storage_keys;
}
