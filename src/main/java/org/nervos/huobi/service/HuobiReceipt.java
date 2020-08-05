package org.nervos.huobi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.math.BigInteger;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.nervos.muta.client.type.graphql_schema.*;

@Getter
@Slf4j
public class HuobiReceipt extends Receipt {

    private final BigInteger consumedFee;

    private final boolean txError;

    public HuobiReceipt() {
        super();
        this.consumedFee = BigInteger.ZERO;
        this.txError = true;
    }

    public HuobiReceipt(
            GUint64 height,
            GUint64 cyclesUsed,
            List<Event> events,
            GHash stateRoot,
            GHash txHash,
            ReceiptResponse response)
            throws JsonProcessingException {
        super(height, cyclesUsed, events, stateRoot, txHash, response);
        this.consumedFee = HuobiUtil.extractConsumedFee(events);
        this.txError = response.getResponse().isError();
    }

    public static HuobiReceipt fromReceipt(Receipt receipt) throws JsonProcessingException {
        return new HuobiReceipt(
                receipt.getHeight(),
                receipt.getCyclesUsed(),
                receipt.getEvents(),
                receipt.getStateRoot(),
                receipt.getTxHash(),
                receipt.getResponse());
    }
}
