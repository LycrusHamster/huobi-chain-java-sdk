package org.nervos.huobi;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.nervos.huobi.service.HuobiParsedServiceResponse;
import org.nervos.huobi.service.HuobiReceipt;
import org.nervos.huobi.service.governance.type.ConsumedTxFee;
import org.nervos.muta.EventRegisterEntry;
import org.nervos.muta.Muta;
import org.nervos.muta.client.Client;
import org.nervos.muta.client.type.MutaRequestOption;
import org.nervos.muta.client.type.ParsedEvent;
import org.nervos.muta.client.type.ParsedServiceResponse;
import org.nervos.muta.client.type.graphql_schema.GHash;
import org.nervos.muta.wallet.Account;

@Getter
@Slf4j
public class Huobi extends Muta {
    public Huobi(Client client, Account account, MutaRequestOption defaultReqOption) {
        super(client, account, defaultReqOption);
        this.register(
                Arrays.asList(
                        new EventRegisterEntry<>(
                                ConsumedTxFee.name, new TypeReference<ConsumedTxFee>() {})));
    }

    public Huobi(
            Client client,
            Account account,
            MutaRequestOption defaultReqOption,
            List<EventRegisterEntry<?>> eventRegisterEntries) {
        super(client, account, defaultReqOption, eventRegisterEntries);
        this.register(
                Arrays.asList(
                        new EventRegisterEntry<>(
                                ConsumedTxFee.name, new TypeReference<ConsumedTxFee>() {})));
    }

    public Huobi defaultHuobi() {
        return new Huobi(
                Client.defaultClient(),
                Account.defaultAccount(),
                MutaRequestOption.defaultMutaRequestOption());
    }

    @Override
    public HuobiReceipt getReceipt(GHash txHash) throws IOException {
        return HuobiReceipt.fromReceipt(this.client.getReceipt(txHash));
    }

    @Override
    public <R> HuobiParsedServiceResponse<R> getReceiptSucceedData(
            GHash txHash, TypeReference<R> tr, @NonNull List<ParsedEvent<?>> events)
            throws IOException {
        ParsedServiceResponse<R> receiptSucceedData =
                super.getReceiptSucceedData(txHash, tr, events);

        return new HuobiParsedServiceResponse<R>(
                receiptSucceedData.getCode(),
                receiptSucceedData.getSucceedData(),
                receiptSucceedData.getErrorMessage(),
                events);
    }
}
