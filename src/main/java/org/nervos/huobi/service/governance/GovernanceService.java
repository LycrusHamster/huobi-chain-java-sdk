package org.nervos.huobi.service.governance;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.nervos.huobi.service.governance.type.*;
import org.nervos.muta.Muta;

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

  public String get_admin_address() throws IOException {
    String statusList =
        muta.queryService(
            SERVICE_NAME, METHOD_GET_ADMIN_ADDRESS, null, new TypeReference<String>() {});
    return statusList;
  }

  public GovernanceInfo get_govern_info() throws IOException {
    GovernanceInfo governanceInfo =
        muta.queryService(
            SERVICE_NAME, METHOD_GET_GOVERN_INFO, null, new TypeReference<GovernanceInfo>() {});
    return governanceInfo;
  }

  public String get_tx_failure_fee() throws IOException {
    String ret =
        muta.queryService(
            SERVICE_NAME, METHOD_GET_TX_FAILURE_FEE, null, new TypeReference<String>() {});
    return ret;
  }

  public String get_tx_floor_fee() throws IOException {
    String ret =
        muta.queryService(
            SERVICE_NAME, METHOD_GET_TX_FLOOR_FEE, null, new TypeReference<String>() {});
    return ret;
  }

  public void set_admin(SetAdminPayload adminPayload) throws IOException {
    muta.sendTransactionAndPollResult(
        SERVICE_NAME, METHOD_SET_ADMIN, adminPayload, new TypeReference<Void>() {});
  }

  public void set_govern_info(SetGovernInfoPayload governInfoPayload) throws IOException {
    muta.sendTransactionAndPollResult(
        SERVICE_NAME, METHOD_SET_GOVERN_INFO, governInfoPayload, new TypeReference<Void>() {});
  }

  public void set_miner(MinerChargeConfig minerChargeConfig) throws IOException {
    muta.sendTransactionAndPollResult(
        SERVICE_NAME, METHOD_SET_MINER, minerChargeConfig, new TypeReference<Void>() {});
  }

  public void update_metadata(UpdateMetadataPayload updateMetadataPayload) throws IOException {
    muta.sendTransactionAndPollResult(
        SERVICE_NAME, METHOD_UPDATE_METADATA, updateMetadataPayload, new TypeReference<Void>() {});
  }

  public void update_validators(UpdateValidatorsPayload updateValidatorsPayload)
      throws IOException {
    muta.sendTransactionAndPollResult(
        SERVICE_NAME,
        METHOD_UPDATE_VALIDATORS,
        updateValidatorsPayload,
        new TypeReference<Void>() {});
  }

  public void update_interval(UpdateIntervalPayload updateIntervalPayload) throws IOException {
    muta.sendTransactionAndPollResult(
        SERVICE_NAME, METHOD_UPDATE_INTERVAL, updateIntervalPayload, new TypeReference<Void>() {});
  }

  public void update_ratio(UpdateRatioPayload updateRatioPayload) throws IOException {
    muta.sendTransactionAndPollResult(
        SERVICE_NAME, METHOD_UPDATE_RATIO, updateRatioPayload, new TypeReference<Void>() {});
  }
}
