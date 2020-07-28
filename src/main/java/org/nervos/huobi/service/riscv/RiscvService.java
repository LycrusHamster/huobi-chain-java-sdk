package org.nervos.huobi.service.riscv;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.nervos.huobi.service.riscv.type.*;
import org.nervos.muta.EventRegisterEntry;
import org.nervos.muta.Muta;

@AllArgsConstructor
@Getter
public class RiscvService {
    public static final String SERVICE_NAME = "riscv";
    public static final String METHOD_CALL = "call";
    public static final String METHOD_CHECK_DEPLOY_AUTH = "check_deploy_auth";
    public static final String METHOD_GET_CONTRACT = "get_contract";
    public static final String METHOD_EXEC = "exec";
    public static final String METHOD_GRANT_DEPLOY_AUTH = "grant_deploy_auth";
    public static final String METHOD_REVOKE_DEPLOY_AUTH = "revoke_deploy_auth";
    public static final String METHOD_DEPLOY = "deploy";
    public static final String METHOD_APPROVE_CONTRACTS = "approve_contracts";
    public static final String METHOD_REVOKE_CONTRACTS = "revoke_contracts";
    public static final String EVENT_GRANT_AUTH = "GrantAuth";
    public static final String EVENT_REVOKE_AUTH = "RevokeAuth";
    public static final String EVENT_APPROVE_CONTRACT = "ApproveContract";
    public static final String EVENT_REVOKE_CONTRACT = "RevokeContract";
    public static final List<EventRegisterEntry<?>> eventRegistry;

    static {
        eventRegistry =
                Arrays.asList(
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_GRANT_AUTH,
                                new TypeReference<AddressList>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_REVOKE_AUTH,
                                new TypeReference<AddressList>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_APPROVE_CONTRACT,
                                new TypeReference<AddressList>() {}),
                        new EventRegisterEntry<>(
                                SERVICE_NAME,
                                EVENT_REVOKE_CONTRACT,
                                new TypeReference<AddressList>() {}));
    }

    private final Muta muta;

    public String call(ExecPayload execPayload) throws IOException {
        String result =
                muta.queryService(
                        SERVICE_NAME, METHOD_CALL, execPayload, new TypeReference<String>() {});
        return result;
    }

    public AddressList check_deploy_auth(AddressList addressList) throws IOException {
        AddressList approved =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_CHECK_DEPLOY_AUTH,
                        addressList,
                        new TypeReference<AddressList>() {});
        return approved;
    }

    public GetContractResp get_contract(GetContractPayload getContractPayload) throws IOException {
        GetContractResp ret =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_CONTRACT,
                        getContractPayload,
                        new TypeReference<GetContractResp>() {});
        return ret;
    }

    public String exec(ExecPayload execPayload) throws IOException {
        String ret =
                muta.sendTransactionAndPollResult(
                        SERVICE_NAME, METHOD_EXEC, execPayload, new TypeReference<String>() {});
        return ret;
    }

    public void grant_deploy_auth(AddressList addressList) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_GRANT_DEPLOY_AUTH, addressList, new TypeReference<Void>() {});
    }

    public void revoke_deploy_auth(AddressList addressList) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_REVOKE_DEPLOY_AUTH, addressList, new TypeReference<Void>() {});
    }

    public DeployResp deploy(DeployPayload deployPayload) throws IOException {
        DeployResp ret =
                muta.sendTransactionAndPollResult(
                        SERVICE_NAME,
                        METHOD_DEPLOY,
                        deployPayload,
                        new TypeReference<DeployResp>() {});
        return ret;
    }

    public void approve_contracts(AddressList addressList) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_APPROVE_CONTRACTS, addressList, new TypeReference<Void>() {});
    }

    public void revoke_contracts(AddressList addressList) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_REVOKE_CONTRACTS, addressList, new TypeReference<Void>() {});
    }
}
