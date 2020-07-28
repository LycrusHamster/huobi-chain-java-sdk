package org.nervos.huobi.service.governance;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.nervos.huobi.service.governance.type.*;
import org.nervos.huobi.service.huobi_asset.type.HookTransferFromPayload;
import org.nervos.muta.EventRegisterEntry;
import org.nervos.muta.Muta;
import org.nervos.muta.client.type.ParsedEvent;

@AllArgsConstructor
@Getter
public class GovernanceService {
    public static final String SERVICE_NAME = "governance";
    public static final String METHOD_GET_ADMIN_ADDRESS = "get_admin_address";
    public static final String METHOD_GET_GOVERN_INFO = "get_govern_info";
    public static final String METHOD_GET_TX_FAILURE_FEE = "get_tx_failure_fee";
    public static final String METHOD_GET_TX_FLOOR_FEE = "get_tx_floor_fee";
    public static final String METHOD_SET_ADMIN = "set_admin";
    public static final String METHOD_SET_GOVERN_INFO = "set_govern_info";
    public static final String METHOD_SET_MINER = "set_miner";
    public static final String METHOD_UPDATE_METADATA = "update_metadata";
    public static final String METHOD_UPDATE_VALIDATORS = "update_validators";
    public static final String METHOD_UPDATE_INTERVAL = "update_interval";
    public static final String METHOD_UPDATE_RATIO = "update_ratio";
    public static final String EVENT_SET_ADMIN = "SetAdmin";
    public static final String EVENT_SET_GOVERN_INFO = "SetGovernInfo";
    public static final String EVENT_SET_MINER = "SetMiner";
    public static final String EVENT_UPDATE_METADATA = "UpdateMetadata";
    public static final String EVENT_UPDATE_VALIDATORS = "UpdateValidators";
    public static final String EVENT_UPDATE_INTERVAL = "UpdateInterval";
    public static final String EVENT_UPDATE_RATIO = "UpdateRatio";
    public static final String EVENT_RECORD_PROFIT = "RecordProfit";
    public static final String EVENT_PLEDGE_FEE = "PledgeFee";
    public static final String EVENT_DEDUCT_FEE = "DeductFee";
    public static final List<EventRegisterEntry<?>> eventRegistry;

    static {
        eventRegistry =
                Arrays.asList(
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_SET_ADMIN,
                                new TypeReference<SetAdminEvent>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_SET_GOVERN_INFO,
                                new TypeReference<SetGovernInfoEvent>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_SET_MINER,
                                new TypeReference<SetMinerEvent>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_UPDATE_METADATA,
                                new TypeReference<UpdateMetadataEvent>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_UPDATE_VALIDATORS,
                                new TypeReference<UpdateValidatorsEvent>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_UPDATE_INTERVAL,
                                new TypeReference<UpdateIntervalEvent>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_UPDATE_RATIO,
                                new TypeReference<UpdateRatioEvent>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_RECORD_PROFIT,
                                new TypeReference<RecordProfitEvent>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_PLEDGE_FEE,
                                new TypeReference<HookTransferFromPayload>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_DEDUCT_FEE,
                                new TypeReference<HookTransferFromPayload>() {}));
    }

    private final Muta muta;

    public String get_admin_address() throws IOException {
        String statusList =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_ADMIN_ADDRESS,
                        null,
                        new TypeReference<String>() {});
        return statusList;
    }

    public GovernanceInfo get_govern_info() throws IOException {
        GovernanceInfo governanceInfo =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_GOVERN_INFO,
                        null,
                        new TypeReference<GovernanceInfo>() {});
        return governanceInfo;
    }

    public String get_tx_failure_fee() throws IOException {
        String ret =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_TX_FAILURE_FEE,
                        null,
                        new TypeReference<String>() {});
        return ret;
    }

    public String get_tx_floor_fee() throws IOException {
        String ret =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_TX_FLOOR_FEE,
                        null,
                        new TypeReference<String>() {});
        return ret;
    }

    public void set_admin(SetAdminPayload adminPayload, List<ParsedEvent<?>> events)
            throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_SET_ADMIN, adminPayload, new TypeReference<Void>() {}, events);
    }

    public void set_govern_info(SetGovernInfoPayload governInfoPayload, List<ParsedEvent<?>> events)
            throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_SET_GOVERN_INFO,
                governInfoPayload,
                new TypeReference<Void>() {},
                events);
    }

    public void set_miner(MinerChargeConfig minerChargeConfig, List<ParsedEvent<?>> events)
            throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_SET_MINER,
                minerChargeConfig,
                new TypeReference<Void>() {},
                events);
    }

    public void update_metadata(
            UpdateMetadataPayload updateMetadataPayload, List<ParsedEvent<?>> events)
            throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_UPDATE_METADATA,
                updateMetadataPayload,
                new TypeReference<Void>() {},
                events);
    }

    public void update_validators(
            UpdateValidatorsPayload updateValidatorsPayload, List<ParsedEvent<?>> events)
            throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_UPDATE_VALIDATORS,
                updateValidatorsPayload,
                new TypeReference<Void>() {},
                events);
    }

    public void update_interval(
            UpdateIntervalPayload updateIntervalPayload, List<ParsedEvent<?>> events)
            throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_UPDATE_INTERVAL,
                updateIntervalPayload,
                new TypeReference<Void>() {},
                events);
    }

    public void update_ratio(UpdateRatioPayload updateRatioPayload, List<ParsedEvent<?>> events)
            throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_UPDATE_RATIO,
                updateRatioPayload,
                new TypeReference<Void>() {},
                events);
    }
}
