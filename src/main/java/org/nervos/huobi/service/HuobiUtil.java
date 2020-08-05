package org.nervos.huobi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.nervos.huobi.service.governance.type.ConsumedTxFee;
import org.nervos.muta.client.type.ParsedEvent;
import org.nervos.muta.client.type.graphql_schema.Event;

public class HuobiUtil {

    public static BigInteger extractConsumedFee(List<Event> events) throws JsonProcessingException {
        Collections.reverse(events);
        Optional<Event> event =
                events.stream().filter(e -> e.getName().equals(ConsumedTxFee.name)).findFirst();

        if (event.isPresent()) {
            ConsumedTxFee consumedTxFee =
                    new ObjectMapper().readValue(event.get().getData(), ConsumedTxFee.class);
            return consumedTxFee.getAmount().get();
        }

        return BigInteger.ZERO;
    }

    public static BigInteger extractConsumedFee_(List<ParsedEvent<?>> events) {
        Collections.reverse(events);
        Optional<ParsedEvent<?>> event =
                events.stream().filter(e -> e.getName().equals(ConsumedTxFee.name)).findFirst();

        if (event.isPresent()) {
            ConsumedTxFee consumedTxFee = (ConsumedTxFee) event.get().getData();
            return consumedTxFee.getAmount().get();
        }

        return BigInteger.ZERO;
    }
}
