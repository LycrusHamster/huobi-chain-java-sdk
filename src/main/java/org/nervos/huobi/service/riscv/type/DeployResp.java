package org.nervos.huobi.service.riscv.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeployResp {
  private String address;
  private String init_ret;
}
