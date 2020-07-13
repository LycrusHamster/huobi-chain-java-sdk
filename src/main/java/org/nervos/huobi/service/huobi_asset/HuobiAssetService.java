package org.nervos.huobi.service.huobi_asset;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.nervos.huobi.service.huobi_asset.type.*;
import org.nervos.muta.Muta;

@AllArgsConstructor
@Getter
public class HuobiAssetService {
    private final Muta muta;

    public static final String SERVICE_NAME = "asset";
    public static final String METHOD_GET_NATIVE_ASSET = "get_native_asset";
    public static final String METHOD_GET_ASSET = "get_asset";
    public static final String METHOD_GET_BALANCE = "get_balance";
    public static final String METHOD_GET_ALLOWANCE = "get_allowance";
    public static final String METHOD_CREATE_ASSET = "create_asset";
    public static final String METHOD_TRANSFER = "transfer";
    public static final String METHOD_APPROVE = "approve";
    public static final String METHOD_TRANSFER_FROM = "transfer_from";
    public static final String METHOD_CHANGE_ADMIN = "change_admin";
    public static final String METHOD_MINT = "mint";
    public static final String METHOD_BURN = "burn";
    public static final String METHOD_RELAY = "relay";

    public Asset get_native_asset() throws IOException {
        Asset asset =
                muta.queryService(
                        SERVICE_NAME, METHOD_GET_NATIVE_ASSET, null, new TypeReference<Asset>() {});
        return asset;
    }

    public Asset get_asset(GetAssetPayload getAssetPayload) throws IOException {
        Asset asset =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_ASSET,
                        getAssetPayload,
                        new TypeReference<Asset>() {});
        return asset;
    }

    public GetBalanceResponse get_balance(GetBalancePayload getBalancePayload) throws IOException {
        GetBalanceResponse getBalanceResponse =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_BALANCE,
                        getBalancePayload,
                        new TypeReference<GetBalanceResponse>() {});
        return getBalanceResponse;
    }

    public GetAllowanceResponse get_allowance(GetAllowancePayload getAllowancePayload)
            throws IOException {
        GetAllowanceResponse getAllowanceResponse =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_ALLOWANCE,
                        getAllowancePayload,
                        new TypeReference<GetAllowanceResponse>() {});
        return getAllowanceResponse;
    }

    public Asset create_asset(CreateAssetPayload createAssetPayload) throws IOException {
        Asset asset =
                muta.sendTransactionAndPollResult(
                        SERVICE_NAME,
                        METHOD_CREATE_ASSET,
                        createAssetPayload,
                        new TypeReference<Asset>() {});
        return asset;
    }

    public void transfer(TransferPayload transferPayload) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_TRANSFER, transferPayload, new TypeReference<Void>() {});
    }

    public void approve(ApprovePayload approvePayload) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_APPROVE, approvePayload, new TypeReference<Void>() {});
    }

    public void transfer_from(TransferFromPayload transferFromPayload) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_TRANSFER_FROM,
                transferFromPayload,
                new TypeReference<Void>() {});
    }

    public void change_admin(ChangeAdminPayload changeAdminPayload) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_CHANGE_ADMIN,
                changeAdminPayload,
                new TypeReference<Void>() {});
    }

    public void mint(MintAssetPayload mintAssetPayload) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_MINT, mintAssetPayload, new TypeReference<Void>() {});
    }

    public void burn(BurnAssetPayload burnAssetPayload) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_BURN, burnAssetPayload, new TypeReference<Void>() {});
    }

    public void relay(RelayAssetPayload relayAssetPayload) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_RELAY, relayAssetPayload, new TypeReference<Void>() {});
    }
}
