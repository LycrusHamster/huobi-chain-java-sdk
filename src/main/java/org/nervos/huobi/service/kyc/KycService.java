package org.nervos.huobi.service.kyc;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.nervos.huobi.service.kyc.type.*;
import org.nervos.muta.Muta;

@AllArgsConstructor
@Getter
public class KycService {
    private final Muta muta;
    public static final String SERVICE_NAME = "kyc";
    public static final String METHOD_GET_ORGS = "get_orgs";
    public static final String METHOD_GET_ORG_INFO = "get_org_info";
    public static final String METHOD_GET_ORG_SUPPORTED_TAG = "get_org_supported_tags";
    public static final String METHOD_GET_USER_TAGS = "get_user_tags";
    public static final String METHOD_EVAL_USER_TAG_EXPRESSION = "eval_user_tag_expression";
    public static final String METHOD_CHAGNE_ORG_APPROVED = "change_org_approved";
    public static final String METHOD_CHANGE_SERVICE_ADMIN = "change_service_admin";
    public static final String METHOD_CHANGE_ORG_ADMIN = "change_org_admin";
    public static final String METHOD_REGISTER_ORG = "register_org";
    public static final String METHOD_UPDATE_SUPPORTED_TAGS = "update_supported_tags";
    public static final String METHOD_UPDATE_USER_TAGS = "update_user_tags";

    public List<String> get_orgs() throws IOException {
        List<String> orgNames =
                muta.queryService(
                        SERVICE_NAME, METHOD_GET_ORGS, null, new TypeReference<List<String>>() {});
        return orgNames;
    }

    public KycOrgInfo get_org_info() throws IOException {
        KycOrgInfo kycOrgInfo =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_ORG_INFO,
                        null,
                        new TypeReference<KycOrgInfo>() {});
        return kycOrgInfo;
    }

    public List<String> get_org_supported_tags() throws IOException {
        List<String> supported_tags =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_ORG_SUPPORTED_TAG,
                        null,
                        new TypeReference<List<String>>() {});
        return supported_tags;
    }

    public Map<String, List<String>> get_user_tags(GetUserTags getUserTags) throws IOException {
        Map<String, List<String>> user_tags =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_GET_USER_TAGS,
                        null,
                        new TypeReference<Map<String, List<String>>>() {});
        return user_tags;
    }

    public boolean eval_user_tag_expression(EvalUserTagExpression evalUserTagExpression)
            throws IOException {
        boolean ret =
                muta.queryService(
                        SERVICE_NAME,
                        METHOD_EVAL_USER_TAG_EXPRESSION,
                        null,
                        new TypeReference<Boolean>() {});
        return ret;
    }

    public void change_org_approved(ChangeOrgApproved changeOrgApproved) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_CHAGNE_ORG_APPROVED,
                changeOrgApproved,
                new TypeReference<ChangeOrgApproved>() {});
        return;
    }

    public void change_service_admin(ChangeServiceAdmin changeServiceAdmin) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_CHANGE_SERVICE_ADMIN,
                changeServiceAdmin,
                new TypeReference<Void>() {});
        return;
    }

    public void change_org_admin(ChangeOrgAdmin changeOrgAdmin) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_CHANGE_ORG_ADMIN,
                changeOrgAdmin,
                new TypeReference<Void>() {});
        return;
    }

    public void register_org(RegisterNewOrg registerNewOrg) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_REGISTER_ORG, registerNewOrg, new TypeReference<Void>() {});
        return;
    }

    public void update_supported_tags(UpdateOrgSupportTags updateOrgSupportTags)
            throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_UPDATE_SUPPORTED_TAGS,
                updateOrgSupportTags,
                new TypeReference<Void>() {});
        return;
    }

    public void update_user_tags(UpdateUserTags updateUserTags) throws IOException {
        muta.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_UPDATE_USER_TAGS,
                updateUserTags,
                new TypeReference<Void>() {});
        return;
    }
}
