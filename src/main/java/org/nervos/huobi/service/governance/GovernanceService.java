package org.nervos.huobi.service.governance;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.nervos.huobi.service.governance.type.*;
import org.nervos.muta.Muta;
import org.nervos.muta.util.Util;

import java.io.IOException;

@AllArgsConstructor
@Getter
public class GovernanceService {
    private final Muta muta;

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

    public AddressResult get_admin_address() throws IOException {
        AddressResult statusList = muta.queryService(SERVICE_NAME, METHOD_GET_ADMIN_ADDRESS, null, AddressResult.class);
        return statusList;
    }

    public GovernanceInfo get_govern_info() throws IOException {
        GovernanceInfo governanceInfo = muta.queryService(SERVICE_NAME, METHOD_GET_GOVERN_INFO, null, GovernanceInfo.class);
        return governanceInfo;
    }

    public U64Result get_tx_failure_fee() throws IOException {
        U64Result u64Result = muta.queryService(SERVICE_NAME, METHOD_GET_TX_FAILURE_FEE, null, U64Result.class);
        return u64Result;
    }

    public U64Result get_tx_floor_fee() throws IOException {
        U64Result u64Result = muta.queryService(SERVICE_NAME, METHOD_GET_TX_FLOOR_FEE, null, U64Result.class);
        return u64Result;
    }

    public void set_admin(SetAdminPayload adminPayload) throws IOException {
        muta.sendTransactionAndPollResult(SERVICE_NAME, METHOD_SET_ADMIN, adminPayload, Util.MutaVoid.class);
    }

    public void set_govern_info(SetGovernInfoPayload governInfoPayload) throws IOException {
        muta.sendTransactionAndPollResult(SERVICE_NAME, METHOD_SET_GOVERN_INFO, governInfoPayload, Util.MutaVoid.class);
    }

    public void set_miner(MinerChargeConfig minerChargeConfig) throws IOException {
        muta.sendTransactionAndPollResult(SERVICE_NAME, METHOD_SET_MINER, minerChargeConfig, Util.MutaVoid.class);
    }

    public void update_metadata(UpdateMetadataPayload updateMetadataPayload) throws IOException {
        muta.sendTransactionAndPollResult(SERVICE_NAME, METHOD_UPDATE_METADATA, updateMetadataPayload, Util.MutaVoid.class);
    }

    public void update_validators(UpdateValidatorsPayload updateValidatorsPayload) throws IOException {
        muta.sendTransactionAndPollResult(SERVICE_NAME, METHOD_UPDATE_VALIDATORS, updateValidatorsPayload, Util.MutaVoid.class);
    }

    public void update_interval(UpdateIntervalPayload updateIntervalPayload) throws IOException {
        muta.sendTransactionAndPollResult(SERVICE_NAME, METHOD_UPDATE_INTERVAL, updateIntervalPayload, Util.MutaVoid.class);
    }

    public void update_ratio(UpdateRatioPayload updateRatioPayload) throws IOException {
        muta.sendTransactionAndPollResult(SERVICE_NAME, METHOD_UPDATE_RATIO, updateRatioPayload, Util.MutaVoid.class);
    }
}
