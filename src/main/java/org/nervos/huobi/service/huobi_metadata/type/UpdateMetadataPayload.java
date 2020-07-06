package org.nervos.huobi.service.huobi_metadata.type;

import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nervos.muta.client.type.primitive.ValidatorExtend;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMetadataPayload {
  private List<ValidatorExtend> verifier_list;
  private BigInteger interval;
  private BigInteger propose_ratio;
  private BigInteger prevote_ratio;
  private BigInteger precommit_ratio;
  private BigInteger brake_ratio;
  private BigInteger timeout_gap;
  private BigInteger cycles_limit;
  private BigInteger cycles_price;
  private BigInteger tx_num_limit;
  private BigInteger max_tx_size;
}
