package org.nervos.huobi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.function.Predicate;
import lombok.Getter;
import org.nervos.huobi.service.huobi_asset.type.GetBalancePayload;
import org.nervos.huobi.service.huobi_asset.type.GetBalanceResponse;
import org.nervos.muta.Muta;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.Hash;
import org.nervos.muta.client.type.primitive.U64;

@Getter
public class CheckBalance {
    public final Predicate<Muta> sendTxBeforeHook;
    public final Address caller;
    public final Hash asset_id;
    public final U64 tx_failure_fee;

    public CheckBalance(
            Predicate<Muta> sendTxBeforeHook, Address caller, Hash asset_id, U64 tx_failure_fee) {
        this.sendTxBeforeHook = sendTxBeforeHook;
        this.caller = caller;
        this.asset_id = asset_id;
        this.tx_failure_fee = tx_failure_fee;
        sendTxBeforeHook =
                muta -> {
                    GetBalancePayload getBalancePayload = new GetBalancePayload(asset_id, caller);
                    try {
                        GetBalanceResponse getBalanceResponse =
                                muta.queryService(
                                        "asset",
                                        "get_balance",
                                        getBalancePayload,
                                        new TypeReference<GetBalanceResponse>() {});
                        return getBalanceResponse.getBalance().get().compareTo(tx_failure_fee.get())
                                > 0;
                    } catch (IOException e) {
                        return false;
                    }
                };
    }
}
