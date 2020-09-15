package org.nervos.huobi.service.transfer_quota;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.nervos.huobi.Huobi;
import org.nervos.huobi.service.kyc.type.*;
import org.nervos.huobi.service.transfer_quota.type.*;
import org.nervos.muta.EventRegisterEntry;
import org.nervos.muta.client.type.ParsedEvent;

@Getter
public class TransferQuotaService {
    public static final String SERVICE_NAME = "transfer_quota";
    public static final String METHOD_CHANGE_ASSET_CONFIG = "change_asset_config";
    public static final String METHOD_GET_ASSET_CONFIG = "get_asset_config";
    public static final String METHOD_CHANGE_RECORD = "change_record";
    public static final String METHOD_GET_RECORD = "get_record";

    public static final String EVENT_CHANGE_RECORD = "ChangeRecord";
    public static final List<EventRegisterEntry<?>> eventRegistry;

    static {
        eventRegistry =
                Arrays.asList(
                        new EventRegisterEntry<>(
                                EVENT_CHANGE_RECORD, new TypeReference<ChangeRecordEvent>() {}));
    }

    private final Huobi huobi;

    public TransferQuotaService(Huobi huobi) {
        this.huobi = huobi;
    }

    public void change_asset_config(
            ChangeAssetConfigPayload changeAssetConfigPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_CHANGE_ASSET_CONFIG,
                changeAssetConfigPayload,
                new TypeReference<Void>() {},
                events);
        return;
    }

    public AssetConfig get_asset_config(GetAssetConfigPayload getAssetConfigPayload)
            throws IOException {
        AssetConfig assetConfig =
                huobi.queryService(
                        SERVICE_NAME,
                        METHOD_GET_ASSET_CONFIG,
                        getAssetConfigPayload,
                        new TypeReference<AssetConfig>() {});
        return assetConfig;
    }

    public void change_record(ChangeRecordPayload changeRecordPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_CHANGE_RECORD,
                changeRecordPayload,
                new TypeReference<Void>() {},
                events);
        return;
    }

    public Record get_record(GetRecordPayload getRecordPayload) throws IOException {
        Record record =
                huobi.queryService(
                        SERVICE_NAME,
                        METHOD_GET_RECORD,
                        getRecordPayload,
                        new TypeReference<Record>() {});
        return record;
    }
}
