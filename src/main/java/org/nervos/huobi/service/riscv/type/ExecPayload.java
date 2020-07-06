package org.nervos.huobi.service.riscv.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecPayload {
  private String address;
  private String args;
}
