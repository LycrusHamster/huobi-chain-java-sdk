package org.nervos.huobi.service.huobi_asset;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.nervos.huobi.Huobi;
import org.nervos.huobi.service.huobi_asset.type.*;
import org.nervos.muta.EventRegisterEntry;
import org.nervos.muta.client.type.ParsedEvent;
import org.nervos.muta.client.type.primitive.Address;
import org.nervos.muta.service.asset.type.ApproveEvent;

@Getter
public class HuobiAssetService {
    public static final String SERVICE_NAME = "asset";
    public static final String METHOD_GET_NATIVE_ASSET = "get_native_asset";
    public static final String METHOD_GET_ADMIN = "get_admin";
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
    public static final String EVENT_CREATE_ASSET = "CreateAsset";
    public static final String EVENT_TRANSFER_ASSET = "TransferAsset";
    public static final String EVENT_TRANSFER_FROM = "TransferFrom";
    public static final String EVENT_HOOK_TRANSFER_FROM = "HookTransferFrom";
    public static final String EVENT_APPROVE_ASSET = "ApproveAsset";
    public static final String EVENT_CHANGE_ADMIN = "ChangeAdmin";
    public static final String EVENT_MINT_ASSET = "MintAsset";
    public static final String EVENT_BURN_ASSET = "BurnAsset";
    public static final String EVENT_RELAY_ASSET = "RelayAsset";
    public static final List<EventRegisterEntry<?>> eventRegistry;

    static {
        eventRegistry =
                Arrays.asList(
                        new EventRegisterEntry<>(EVENT_CREATE_ASSET, new TypeReference<Asset>() {}),
                        new EventRegisterEntry<>(
                                EVENT_TRANSFER_ASSET, new TypeReference<TransferEvent>() {}),
                        new EventRegisterEntry<>(
                                EVENT_TRANSFER_FROM, new TypeReference<TransferFromEvent>() {}),
                        new EventRegisterEntry<>(
                                EVENT_HOOK_TRANSFER_FROM,
                                new TypeReference<TransferFromEvent>() {}),
                        new EventRegisterEntry<>(
                                EVENT_APPROVE_ASSET, new TypeReference<ApproveEvent>() {}),
                        new EventRegisterEntry<>(
                                EVENT_CHANGE_ADMIN, new TypeReference<ChangeAdminPayload>() {}),
                        new EventRegisterEntry<>(
                                EVENT_MINT_ASSET, new TypeReference<MintAssetEvent>() {}),
                        new EventRegisterEntry<>(
                                EVENT_BURN_ASSET, new TypeReference<BurnAssetEvent>() {}),
                        new EventRegisterEntry<>(
                                EVENT_RELAY_ASSET, new TypeReference<RelayAssetEvent>() {}));
    }

    private final Huobi huobi;

    public HuobiAssetService(Huobi huobi) {
        this.huobi = huobi;
        huobi.register(eventRegistry);
    }

    public Asset get_native_asset() throws IOException {
        Asset asset =
                huobi.queryService(
                        SERVICE_NAME, METHOD_GET_NATIVE_ASSET, null, new TypeReference<Asset>() {});
        return asset;
    }

    public Asset get_asset(GetAssetPayload getAssetPayload) throws IOException {
        Asset asset =
                huobi.queryService(
                        SERVICE_NAME,
                        METHOD_GET_ASSET,
                        getAssetPayload,
                        new TypeReference<Asset>() {});
        return asset;
    }

    public GetBalanceResponse get_balance(GetBalancePayload getBalancePayload) throws IOException {
        GetBalanceResponse getBalanceResponse =
                huobi.queryService(
                        SERVICE_NAME,
                        METHOD_GET_BALANCE,
                        getBalancePayload,
                        new TypeReference<GetBalanceResponse>() {});
        return getBalanceResponse;
    }

    public GetAllowanceResponse get_allowance(GetAllowancePayload getAllowancePayload)
            throws IOException {
        GetAllowanceResponse getAllowanceResponse =
                huobi.queryService(
                        SERVICE_NAME,
                        METHOD_GET_ALLOWANCE,
                        getAllowancePayload,
                        new TypeReference<GetAllowanceResponse>() {});
        return getAllowanceResponse;
    }

    public Asset create_asset(CreateAssetPayload createAssetPayload, List<ParsedEvent<?>> events)
            throws IOException {
        Asset asset =
                huobi.sendTransactionAndPollResult(
                        SERVICE_NAME,
                        METHOD_CREATE_ASSET,
                        createAssetPayload,
                        new TypeReference<Asset>() {},
                        events);
        return asset;
    }

    public void transfer(TransferPayload transferPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_TRANSFER,
                transferPayload,
                new TypeReference<Void>() {},
                events);
    }

    public void approve(ApprovePayload approvePayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_APPROVE, approvePayload, new TypeReference<Void>() {}, events);
    }

    public void transfer_from(TransferFromPayload transferFromPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_TRANSFER_FROM,
                transferFromPayload,
                new TypeReference<Void>() {},
                events);
    }

    public void change_admin(ChangeAdminPayload changeAdminPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_CHANGE_ADMIN,
                changeAdminPayload,
                new TypeReference<Void>() {},
                events);
    }

    public void mint(MintAssetPayload mintAssetPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_MINT, mintAssetPayload, new TypeReference<Void>() {}, events);
    }

    public void burn(BurnAssetPayload burnAssetPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_BURN, burnAssetPayload, new TypeReference<Void>() {}, events);
    }

    public void relay(RelayAssetPayload relayAssetPayload, List<ParsedEvent<?>> events)
            throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_RELAY,
                relayAssetPayload,
                new TypeReference<Void>() {},
                events);
    }

    public Address get_admin() throws IOException {
        Address address =
                huobi.queryService(SERVICE_NAME, METHOD_GET_ADMIN, new TypeReference<Address>() {});
        return address;
    }
}
