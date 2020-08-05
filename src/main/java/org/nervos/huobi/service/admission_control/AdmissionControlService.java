package org.nervos.huobi.service.admission_control;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.nervos.huobi.Huobi;
import org.nervos.huobi.service.admission_control.type.AddressList;
import org.nervos.huobi.service.admission_control.type.NewAdmin;
import org.nervos.huobi.service.admission_control.type.StatusList;
import org.nervos.muta.EventRegisterEntry;
import org.nervos.muta.client.type.ParsedEvent;

@Getter
public class AdmissionControlService {
    public static final String SERVICE_NAME = "admission_control";
    public static final String METHOD_STATUS = "status";
    public static final String METHOD_CHANGE_ADMIN = "change_admin";
    public static final String METHOD_FORBID = "forbid";
    public static final String METHOD_PERMIT = "permit";
    public static final String EVENT_CHANGE_ADMIN = "ChangeAdmin";
    public static final String EVENT_FORBID = "Forbid";
    public static final String EVENT_PERMIT = "Permit";
    public static final List<EventRegisterEntry<?>> eventRegistry;

    static {
        eventRegistry =
                Arrays.asList(
                        new EventRegisterEntry<>(
                                EVENT_CHANGE_ADMIN, new TypeReference<NewAdmin>() {}),
                        new EventRegisterEntry<>(EVENT_FORBID, new TypeReference<AddressList>() {}),
                        new EventRegisterEntry<>(
                                EVENT_PERMIT, new TypeReference<AddressList>() {}));
    }

    private final Huobi huobi;

    public AdmissionControlService(Huobi huobi) {
        this.huobi = huobi;
        huobi.register(eventRegistry);
    }

    public StatusList status(AddressList addressList) throws IOException {
        StatusList statusList =
                huobi.queryService(
                        SERVICE_NAME,
                        METHOD_STATUS,
                        addressList,
                        new TypeReference<StatusList>() {});
        return statusList;
    }

    public void change_admin(NewAdmin newAdmin, List<ParsedEvent<?>> events) throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_CHANGE_ADMIN, newAdmin, new TypeReference<Void>() {}, events);
    }

    public void forbid(AddressList addressList, List<ParsedEvent<?>> events) throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_FORBID, addressList, new TypeReference<Void>() {}, events);
    }

    public void permit(AddressList addressList, List<ParsedEvent<?>> events) throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME, METHOD_PERMIT, addressList, new TypeReference<Void>() {}, events);
    }
}
