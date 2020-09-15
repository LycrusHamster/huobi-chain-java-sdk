package org.nervos.huobi.service.timestamp;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.nervos.huobi.Huobi;
import org.nervos.huobi.service.timestamp.type.*;
import org.nervos.muta.EventRegisterEntry;
import org.nervos.muta.client.type.ParsedEvent;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.client.type.primitive.U64;

@Getter
public class TimestampService {
    public static final String SERVICE_NAME = "timestamp";
    public static final String METHOD_NOW = "now";
    public static final String METHOD_FEED_TIME = "feed_time";
    public static final String METHOD_GET_ADMIN = "get_admin";
    public static final String METHOD_GET_INFO = "get_info";
    public static final String METHOD_SET_ADMIN = "set_admin";
    public static final String METHOD_SET_ORACLE = "set_oracle";

    public static final String EVENT_SET_ADMIN = "SetAdmin";
    public static final String EVENT_SET_ORACLE = "SetOracle";
    public static final List<EventRegisterEntry<?>> eventRegistry;

    static {
        eventRegistry =
                Arrays.asList(
                        new EventRegisterEntry<>(
                                EVENT_SET_ADMIN, new TypeReference<SetAdminEvent>() {}),
                        new EventRegisterEntry<>(
                                EVENT_SET_ORACLE, new TypeReference<SetOracleEvent>() {}));
    }

    private final Huobi huobi;

    public TimestampService(Huobi huobi) {
        this.huobi = huobi;
    }

    public U64 now() throws IOException {
        U64 time = huobi.queryService(SERVICE_NAME, METHOD_NOW, null, new TypeReference<U64>() {});
        return time;
    }

    public void feed_time(FeedTimePayload feedTimePayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_FEED_TIME,
                feedTimePayload,
                new TypeReference<Void>() {},
                events);
        return;
    }

    public Address get_admin() throws IOException {
        Address admin =
                huobi.queryService(
                        SERVICE_NAME, METHOD_GET_ADMIN, null, new TypeReference<Address>() {});
        return admin;
    }

    public TimestampInfo get_info() throws IOException {
        TimestampInfo timestamp =
                huobi.queryService(
                        SERVICE_NAME, METHOD_GET_INFO, null, new TypeReference<TimestampInfo>() {});
        return timestamp;
    }

    public void set_admin(SetAdminPayload setAdminPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_SET_ADMIN,
                setAdminPayload,
                new TypeReference<Void>() {},
                events);
        return;
    }

    public void set_oracle(SetOraclePayload setOraclePayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_SET_ORACLE,
                setOraclePayload,
                new TypeReference<Void>() {},
                events);
        return;
    }
}
