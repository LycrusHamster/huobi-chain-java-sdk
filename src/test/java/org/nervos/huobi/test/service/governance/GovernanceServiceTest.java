package org.nervos.huobi.test.service.governance;

import java.io.IOException;
import java.util.List;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.nervos.huobi.Huobi;
import org.nervos.huobi.service.governance.GovernanceService;
import org.nervos.huobi.service.governance.type.MinerChargeConfig;
import org.nervos.muta.client.Client;
import org.nervos.muta.client.type.MutaRequestOption;
import org.nervos.muta.wallet.Account;

@Slf4j
@Data
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GovernanceServiceTest {
    private static Account admin =
            Account.fromHexString(
                    "0x0000000000000000000000000000000000000000000000000000000000000001");
    private static GovernanceService governanceService =
            new GovernanceService(
                    new Huobi(
                            Client.defaultClient(),
                            admin,
                            MutaRequestOption.defaultMutaRequestOption()));

    @Test
    @Order(1)
    public void getMinerChargeMapTest() throws IOException {
        List<MinerChargeConfig> minerChargeConfigs = governanceService.get_miner_charge_map();
        System.out.println(minerChargeConfigs);
    }
}
