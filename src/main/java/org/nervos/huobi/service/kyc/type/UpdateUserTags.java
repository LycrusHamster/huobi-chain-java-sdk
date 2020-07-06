package org.nervos.huobi.service.kyc.type;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserTags {
  private String org_name;
  private String user;
  private Map<String, List<String>> tags;
}
