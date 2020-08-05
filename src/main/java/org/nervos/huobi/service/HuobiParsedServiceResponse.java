package org.nervos.huobi.service;

import java.math.BigInteger;
import java.util.List;
import org.nervos.muta.client.type.ParsedEvent;
import org.nervos.muta.client.type.ParsedServiceResponse;
import org.nervos.muta.client.type.graphql_schema.GUint64;

public class HuobiParsedServiceResponse<T> extends ParsedServiceResponse<T> {

    private final BigInteger consumedFee;

    private final boolean txError;

    public HuobiParsedServiceResponse(
            GUint64 code, T succeedData, String errorMessage, List<ParsedEvent<?>> events) {
        super(code, succeedData, errorMessage);
        this.consumedFee = HuobiUtil.extractConsumedFee_(events);
        this.txError = super.isError();
    }
}
